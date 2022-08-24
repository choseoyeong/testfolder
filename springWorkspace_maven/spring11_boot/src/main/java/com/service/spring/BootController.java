package com.service.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BootController {
	
	@GetMapping("/hello")
	public String doHello(Model model) {
		model.addAttribute("message", "Spring MVC Boot~!");
		
		return "boot_result";
	}
}
