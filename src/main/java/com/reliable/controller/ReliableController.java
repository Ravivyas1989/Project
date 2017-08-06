package com.reliable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReliableController {


	@RequestMapping(method = RequestMethod.GET, value = "/")
	@ResponseBody
	public ModelAndView home() {
		System.out.println("display home");
		ModelAndView mv = new ModelAndView("home");
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	@ResponseBody
	public ModelAndView register(String username, String password) {
		System.out.println("display registration");
		ModelAndView mv = new ModelAndView("register");
		mv.setViewName("register");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	@ResponseBody
	public ModelAndView login() {
		System.out.println("display registration");
		ModelAndView mv = new ModelAndView("login");
		mv.setViewName("login");
		return mv;
	}


	@RequestMapping(value = "/home")
	public ModelAndView homepage() {
		System.out.println("hitting display method");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
		return mv;
	}
	@RequestMapping(value = "/greeting")
	public ModelAndView greet() {
		System.out.println("hitting display method");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("greeting.jsp");
		return mv;
	}

}
