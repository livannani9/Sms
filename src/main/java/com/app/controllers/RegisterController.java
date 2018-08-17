package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	private String register(Model model) {

		model.addAttribute("success","Register Succeessfully");
		return "Register";
	}
		@RequestMapping(value="/logi")
		private String ancorLogin() {

			
			return "login";
		}
}
