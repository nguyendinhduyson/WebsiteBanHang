package poly.edu.controller;

import java.util.List;



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
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import poly.edu.entity.Category;
import poly.edu.entity.Product;
import poly.edu.repository.CategoryRepository;
import poly.edu.repository.ProductRepository;

@Controller
@SessionAttributes("categoriesInfo")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@ModelAttribute("categoriesInfo")
	private List<Category> getAllCategory() {
		return categoryRepo.findAll();
	}
	
	@RequestMapping("/admin/category/index")
	private String showIndex(Model model) {
		model.addAttribute("categorys", categoryRepo.findAll());
		return "admin/category/index";
	}
	
	@RequestMapping("/admin/category/add")
	private String showSave(Model model) {
		model.addAttribute("category", new Category());
		return "admin/category/create";
	}
	
	@PostMapping("/admin/category/save")
	private String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "admin/category/create";
		}
		categoryRepo.save(category);
		return "redirect:/admin/category/index";
	}
	
	
	@RequestMapping("/admin/category/edit/{id}")
	private String editCategory(@PathVariable("id") Integer id, Model model) {
		Optional<Category> category = categoryRepo.findById(id);
		model.addAttribute("category", category);
		return "admin/category/edit";
	}
	
	@PostMapping("/admin/category/update")
	private String updateCategory(@ModelAttribute("category") Category category) {
		categoryRepo.save(category);
		return "redirect:/admin/category/index";
	}
	
	@RequestMapping("/admin/category/delete/{id}")
	private String deleteCategory(@PathVariable("id") Integer id) {
		categoryRepo.deleteById(id);
		return "redirect:/admin/category/index";
	}
	
	@GetMapping("/category/{id}/product")
	public String productOfCategory(@PathVariable("id") Integer id, Model model,
			@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "9") Integer pageSize
			) {
		Category category = new Category();
		category.setId(id);
		
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
		Page<Product> page = productRepo.findAllByCategory(category, pageable);
		model.addAttribute("totalPage", page.getTotalPages());
		model.addAttribute("list", page.getContent());
		return "index";
		
	}
}
