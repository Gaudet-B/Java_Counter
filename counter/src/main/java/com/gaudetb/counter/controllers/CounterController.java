package com.gaudetb.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) session.setAttribute("count", 0);
		Integer current = (Integer) session.getAttribute("count");
		current++;
		session.setAttribute("count", current);
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter") 
	public String counter(HttpSession session, Model model) {
		if (session.getAttribute("count") == null) session.setAttribute("count", 0);
		model.addAttribute("current", session.getAttribute("count"));
		
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		
		return "redirect:/your_server/";
	}

}
