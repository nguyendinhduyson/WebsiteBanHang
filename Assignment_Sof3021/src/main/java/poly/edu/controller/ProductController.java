package poly.edu.controller;



import poly.edu.entity.*;

import poly.edu.repository.CategoryRepository;
import poly.edu.repository.ProductRepository;

import java.io.File;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;

@Controller
public class ProductController {


	@Autowired
	ServletContext context;
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	@GetMapping("/index")
	public String indexGui(Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "9") Integer pageSize) {
		
//		List<Product> productPaging = null;
//		int start = (pageNum - 1) * pageSize + 1;
//		int end = pageNum * pageSize;
//
//		productPaging = products.stream().filter(p -> {
//			return p.getId() >= start && p.getId() <= end;
//		}).collect(Collectors.toList());
//         
//		int totalPage = products.size() / pageSize + (products.size()%pageSize >0 ? 1:0);
//		
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		Page<Product> page = productRepo.findAll(pageable);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
//		model.addAttribute("categorys", categoryRepo.findAll());
		return "index";
		
	}
	
	@GetMapping("/detail/{id}")
	public String detailProduct(@PathVariable Integer id, Model model ) {
		model.addAttribute("product", productRepo.findById(id).orElse(null));
		return "detail";
	}
	
//	@GetMapping("/cart")
//	public String CartGUI() {
//		return "cart";
//	}
	
	@GetMapping("/shop")
	public String ShopGUI() {
		return "shop";
	}
	
	// admin
	
	@RequestMapping("/admin/product/index")
	private String showIndex(Model model) {
		model.addAttribute("products", productRepo.findAll());
		return "admin/product/index";
	}
	
	@RequestMapping("/admin/product/add")
	private String showSave(Model model) {
		model.addAttribute("product", new Product());
		return "admin/product/create";
	}
	
	@PostMapping("/admin/product/save")
	private String saveProduct(@Valid @ModelAttribute("product") Product product,BindingResult result, @RequestParam("imageProduct") MultipartFile file ) {
		
		if(result.hasErrors()) {
			return"admin/product/create";
		}
		String filrOriginal = file.getOriginalFilename();
		String fileDest = context.getRealPath("/upload/"+ filrOriginal);
		
		try {
			file.transferTo(new File(fileDest));
		}catch (Exception e) {
			e.printStackTrace();
		}
		product.setImage(filrOriginal);
		productRepo.save(product);
		return "redirect:/admin/product/index";
	}
	
	@RequestMapping("/admin/product/edit/{id}")
	private String editProduct(@PathVariable("id") Integer id, Model model) {
		Optional<Product> product = productRepo.findById(id);
		model.addAttribute("product", product);
		return "admin/product/edit";
	}
	
	@PostMapping("/admin/product/update")
	private String updateProduct(@ModelAttribute("product") Product product, @RequestParam("imageProduct") MultipartFile file) {
		String filrOriginal = file.getOriginalFilename();
		String fileDest = context.getRealPath("/upload/"+ filrOriginal);
		
		try {
			file.transferTo(new File(fileDest));
		}catch (Exception e) {
			e.printStackTrace();
		}
		product.setImage(filrOriginal);
		productRepo.save(product);
		return "redirect:/admin/product/index";
	}
	
	@RequestMapping("/admin/product/delete/{id}")
	private String updateProduct(@PathVariable("id") Integer id) {
		productRepo.deleteById(id);
		return "redirect:/admin/product/index";
	}
}
