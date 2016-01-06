package com.dc.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("welcome")
public class WelcomeController {
	@RequestMapping(method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("message", "Spring security hello world");
		return "hello";
	}
}
