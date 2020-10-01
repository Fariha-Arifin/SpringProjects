package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String showhome()
	{
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showleaders()
	{
		return "leaders";
	}
	
	@GetMapping("/admin")
	public String showadmin()
	{
		return "admin";
	}
}
