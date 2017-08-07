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

import com.reliable.model.Customer;
import com.reliable.repository.CustomerRepo;

@RestController
public class ReliableController {

	@Autowired
	CustomerRepo rp;

	@RequestMapping(method = RequestMethod.GET, value = "/findall")
	@ResponseBody
	public ModelAndView findall() {
		List<Customer> list = (List<Customer>) rp.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display");
		mv.addObject("list", list);
		for (Customer element : list) {
			System.out.println("Element usernane: " + element.getUserName());
			System.out.println("Element password: " + element.getUserPassword());
		}
		mv.addObject("list", list);

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/write")
	@ResponseBody
	public ModelAndView write(@RequestParam("username") String username, @RequestParam("password") String password) {
		System.out.println("called write");
		Customer customer = new Customer(username, password);
		System.out.println("saving username" + customer.getUserName());
		System.out.println("saving password" + customer.getUserPassword());
		rp.save(customer);
		/*
		 * ModelAndView mv = new ModelAndView("home"); mv.addObject("home");
		 */
		return new ModelAndView("redirect:" + "home");
		// return "redirect:finalPage";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/display")
	@ResponseBody
	public List<Customer> display() {
		return (List<Customer>) rp.findAll();
	}

	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println("display home");
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/register")
	@ResponseBody
	public ModelAndView register(String username, String password) {
		System.out.println("display registration");
		ModelAndView mv = new ModelAndView("register");
		return mv;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public void deleteCourse(@PathVariable Long id) {
		System.out.println("deleting" + id);
		rp.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	@ResponseBody
	public ModelAndView login() {
		System.out.println("display registration");
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping(value = "/home")
	public ModelAndView homepage() {
		System.out.println("hitting display method");
		ModelAndView mv = new ModelAndView();
		return mv;
	}

	@RequestMapping(value = "/greeting")
	public ModelAndView greet() {
		System.out.println("hitting display method");
		ModelAndView mv = new ModelAndView();
		return mv;
	}

}
