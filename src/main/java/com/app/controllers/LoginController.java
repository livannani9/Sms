package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(value="/log",method=RequestMethod.POST)
	private String login() {

		return "index";
	}
	@RequestMapping(value="/regi")
	private String ancorReg(Model model) {

		model.addAttribute("Success","Login Successfully");
		return "Register";
	}
}
