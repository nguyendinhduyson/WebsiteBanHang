package poly.edu.controller;

import java.net.http.HttpRequest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import poly.edu.entity.Users;
import poly.edu.repository.UsersRepository;

@Controller
public class AuthController {
	
	@Autowired
	private UsersRepository usersRepo;
   
	@GetMapping("/login")
	public String loginGui(Model model) {
		model.addAttribute("users", new Users());
		return "login";
	}
	
//	@GetMapping("/logout")
//	private String logout(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return "redirect:/login";
//	}
	
	@PostMapping("/login")
	public String checkLogin(@Valid @ModelAttribute("users") Users users, BindingResult result, HttpSession session, Model model) {
		if(result.hasErrors()) {
			return "login";
		}
//		
		Users userFromDB = usersRepo.findByUsernameAndPassword(users.getUsername(), users.getPassword());
		if(userFromDB != null) {
			session.setAttribute("userLogged", userFromDB);
			return "redirect:/index";
		}
		
		model.addAttribute("message", "Sai username or password");
		return "login";
	}
}
