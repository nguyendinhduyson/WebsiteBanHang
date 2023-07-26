package poly.edu.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import poly.edu.entity.Users;
import poly.edu.repository.UsersRepository;

@Controller
public class AdminController {
	
	@Autowired
	UsersRepository userRepo;
	@RequestMapping("/admin/user/index")
	private String showUsers(Model model) {
		List<Users> users = userRepo.findAll();
		model.addAttribute("users", users);
		return "admin/User/index";
	}
	
	@RequestMapping("/admin/user/add")
	private String showAdd(Model model) {
		model.addAttribute("user", new Users());
		return "admin/User/create";
	}
	
	@PostMapping("/admin/user/save")
	private String saveUser(@Valid @ModelAttribute("user") Users user, BindingResult result) {
		if(result.hasErrors()) {
			return"admin/User/create";
		}
		userRepo.save(user);
		return "redirect:/admin/user/index";
	}
	
	@RequestMapping("/admin/user/edit/{id}")
	private String editUser(@PathVariable("id") Integer id, Model model) {
		Optional<Users> users = userRepo.findById(id);
		model.addAttribute("user", users);
		return "/admin/User/edit";
		
	}
	
	@PostMapping("/admin/user/update")
	private String updateUser(@ModelAttribute("user") Users users) {
		userRepo.save(users);
		return "redirect:/admin/user/index";
	}
	
	@RequestMapping("admin/user/delete/{id}")
	private String deleteUser(@PathVariable("id") Integer id) {
		userRepo.deleteById(id);
		return "redirect:/admin/user/index";
	}

}
