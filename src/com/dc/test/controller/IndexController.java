package com.dc.test.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("index")
public class IndexController {
	@RequestMapping("hello.do")
	public String hello(@RequestParam("id") String id, HttpServletRequest request) {
		System.out.println(id);
		request.getSession().setAttribute("id", id + "_");
		return "t1/test";
	}
	
	@RequestMapping("greeting.do")
	public String greet(@RequestParam("id") String id) {
		System.out.println(id);
		return "t2/test";
	}
	
	@RequestMapping("ajax.do")
	public void ajax(@RequestParam("id") String id, HttpServletResponse response) {
		System.out.println(id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "Jordan");
		map.put("age", "30");
		try {
			response.getWriter().write(JSON.toJSONString(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
