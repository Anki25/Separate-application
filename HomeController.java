package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.User;

//@controller is a predefined annotation which we need to specified for our class to be act like as controller 
@Controller
public class HomeController {
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;

	@Autowired
	CategoryDAO categoryDAO;

	// ctrl+shift+?-to comment ctrl+shift+|-to uncomment
	// request mapping is also predefined a annotation for map the address which
	// jsp page //u need to execute .
	// here in these example my home page should display as soon as I will run
	// my project
	// Without giving a extension of jsp page

	/*
	 * if u want to navigate to other page without carrying the data-
	 * 
	 * @RequestMapping("/") public String home(){ return "home"; }
	 */

	// if u want to navigate with carrying data
	@RequestMapping("/")
	// user defined function which return a ModelAndViewobject .
	public ModelAndView landingPage() {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("message", "Thank You");
		// creating a object for modelandview class and passing the parameter
		// for //jsppage .without extension of jsp page. It will execute your
		// main //page.
		// return new ModelAndView("home");
		List<Category> categoryList = categoryDAO.list(); // <> contains return
															// type
		mv.addObject("categoryList", categoryList);
		System.out.println("Size: " + categoryList.size());

		return mv;
	}

	@RequestMapping("/Sign In")
	public ModelAndView login(@RequestParam(value = "id") String id,
			@RequestParam(value = "password") String password,HttpSession session) {
		String msg;
		ModelAndView mv = new ModelAndView("home");
		user = userDAO.isValidUser(id, password);
		if (user == null) {
			msg = "Invalid User..please try again!!";
		} else {
			if (user.getRole().equals("ROLE_ADMIN")) {
				mv = new ModelAndView("adminhome");
			} else {
				session.setAttribute("welcomeMsg", user.getName());
				session.setAttribute("userID",user.getId());
			}
		}

		mv.addObject("userClickedSignIn", "true");
		return mv;
	}

	@RequestMapping("/Sign Up")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("signup");
		mv.addObject("userClickedSignUp", "true");
		return mv;
	}
}
