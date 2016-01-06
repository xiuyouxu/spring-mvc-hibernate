package com.dc.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dc.test.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@RequestMapping("list.do")
	public @ResponseBody
	String list() {
		return userService.list();
	}
}
