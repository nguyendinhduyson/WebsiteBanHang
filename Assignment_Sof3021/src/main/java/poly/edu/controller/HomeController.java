package poly.edu.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

//	@GetMapping("/login")
//	public String LoginGUI() {
//		return "login";
//	}
	@GetMapping("/register")
	public String RegisterGUI() {
		return "register";
	}
	@GetMapping("/forgotpw")
	public String forgotpwGUI() {
		return "forgot-password";
	}
	
	@GetMapping("/checkout")
	public String CartGUI() {
		return "checkout";
	}
	
	@GetMapping("/403")
	public String Gui403() {
		return "403";
	}
	
	@GetMapping("/hoadon")
	public String GuiHoaDon() {
		return "hoadon";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/index";
		
	}
}
