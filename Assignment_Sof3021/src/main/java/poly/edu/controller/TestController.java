package poly.edu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@RequestMapping("/test")
	 public String home() {
	  System.out.println("Inside handler Method");
	  return "Hello World !! Start using Interceptors";
	 }
}
