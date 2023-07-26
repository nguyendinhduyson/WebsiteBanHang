package poly.edu.controller;

import java.util.Iterator;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

import poly.edu.entity.Oders;
import poly.edu.entity.OdersDetail;
import poly.edu.entity.Product;
import poly.edu.entity.Users;
import poly.edu.repository.OrderDetailRepository;
import poly.edu.repository.OrderRepository;
import poly.edu.repository.ProductRepository;
import poly.edu.repository.UsersRepository;

@Controller
public class CartController {

	@Autowired
	ProductRepository productRepo;

	@Autowired
	OrderDetailRepository orderDetailRepo;

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	UsersRepository usersRepo;
	@Autowired
	HttpServletRequest request;

	@GetMapping("/cart")
	public String ShowCart(Model model, HttpServletRequest request) {
		Users users = (Users) request.getSession().getAttribute("userLogged");
		System.out.println(users.getId());
		Oders oders = orderRepo.getOrder(users.getId());
		System.out.println("id order: " + oders.getId());
		List<OdersDetail> cartItems = orderDetailRepo.findByOders(oders.getId());
		model.addAttribute("cartItem", cartItems);
		return "cart";
	}

//	@RequestParam("quantity") int quantity
//	@RequestParam("idProduct") Integer id
	@PostMapping("/cart/add")
	public String addToCart(HttpServletRequest request1) {
		HttpSession session = request1.getSession();
		Users users = (Users) session.getAttribute("userLogged");
		Oders oders = orderRepo.getOrder(users.getId());
		List<OdersDetail> cartItems = orderDetailRepo.findByOders(oders.getId());
		String Masp = request1.getParameter("idProduct");
		
		Integer Masp1 = Integer.parseInt(Masp);
		System.out.println("id sp "+Masp1);
		Integer soLuongThem = 1;
		for (int i = 0; i < cartItems.size(); i++) {
			if(cartItems.get(i).getProduct().getId() == Masp1) {
				Integer soLuongHienTai = cartItems.get(i).getQuantity();
				Integer soLuongMoi = soLuongHienTai + soLuongThem;
				OdersDetail orderDetail = orderDetailRepo.getorderdetail(users.getId());
				orderDetail.setQuantity(soLuongMoi);
				orderDetailRepo.save(orderDetail);
				return "redirect:/cart";
			}
			
		}
		String id = request1.getParameter("idProduct");
		System.out.println(id);
		Integer id1 = Integer.parseInt(id);
		Product product = productRepo.findById(id1).orElse(null);
		OdersDetail odersDetail = new OdersDetail();
		odersDetail.setOders(oders);
		odersDetail.setProduct(product);
		odersDetail.setPrice(product.getPrice());
		odersDetail.setQuantity(1);
		orderDetailRepo.save(odersDetail);
		return "redirect:/cart";

//		
	}

	@GetMapping("/cart/delete/{id}")
	public String deleteCart(@PathVariable("id") Integer id) {
		orderDetailRepo.deleteById(id);
		return "redirect:/cart";
	}

	@PostMapping("/cart/update")
	public String updateCart(@ModelAttribute("OrderDetail") OdersDetail odersDetail,HttpServletRequest request2) {
		HttpSession session = request2.getSession();
		Users users = (Users) session.getAttribute("userLogged");
		Oders oders = orderRepo.getOrder(users.getId());
		List<OdersDetail> cartItems = orderDetailRepo.findByOders(oders.getId());
		
		orderDetailRepo.save(odersDetail);
		return "redirect:/cart";
	}

	
	
}
