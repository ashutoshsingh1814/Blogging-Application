package com.ashu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashu.binding.LoginForm;
import com.ashu.binding.RegistrationForm;
import com.ashu.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/registration")
	public String loadRegistratonPage(Model model) {
		
	model.addAttribute("regForm", new RegistrationForm());
		return "registration";
	}
	
	
	@PostMapping("/registration")
	public String registratonPage(@ModelAttribute("regForm") RegistrationForm form, Model model) {
		
		boolean status = userService.register(form);
		if(status) {
			model.addAttribute("succMsg", "User Registration Success");
		}
		
		else {
			model.addAttribute("errMsg", "Email already In use");
		}
		
		model.addAttribute("regForm", new RegistrationForm());
		return "registration";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		
		model.addAttribute("logForm", new LoginForm());
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute("logForm") LoginForm form  , Model model) {
		
		boolean status = userService.login(form);
		if(status) {
			model.addAttribute("succMsg", "Login Suceess");
			return "dashboard";
			
		}
		else {
			model.addAttribute("errMsg", "Invalid Login");
			
		}
		return "login";
	}
	

}
