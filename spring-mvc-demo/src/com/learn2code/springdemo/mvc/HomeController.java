package com.learn2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showMyHomePage() {
		return "main-menu";
	}
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld-form";
	}
}
