package com.niit.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.dao.ProductDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Product;
import com.niit.model.User;


//@controller is a predefined annotation which we need to specified for our class to be act like as controller 
@Controller
public class HomeController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	// request mapping is also predefined a annotation for map the address which
	// jsp page //u need to execute .
	// here in these example my home page should display as soon as I will run
	// my project
	// Without giving a extension of jsp page

	@RequestMapping("/")
	// user defined function which return a ModelAndViewobject .
	public ModelAndView LandingPage() {
		System.out.println("In Home page");
		// creating a object for modelandview class and passing the parameter
		// for //jsppage .without extension of jsp page. It will execute your
		// main //page.
		return new ModelAndView("home");

	}
	
	@RequestMapping("/adminhome")
	public ModelAndView adminPage() {
		System.out.println("In Admin page");

		return new ModelAndView("adminhome");

	}

	
		@RequestMapping("/home1")
	public ModelAndView showHome() {
		System.out.println("In home page");
		return new ModelAndView("home1");

	}

	@RequestMapping("/aboutus")
	public ModelAndView showAboutUs() {
		System.out.println("In About us page");
		return new ModelAndView("aboutus");

	}

	@RequestMapping("/contactus")
	public ModelAndView showContactUs() {
		System.out.println("In Contact us page");
		return new ModelAndView("contactus");

	}

	@RequestMapping("/privacynotice")
	public ModelAndView showPrivacy() {
		System.out.println("In Privacy Notice page");
		return new ModelAndView("privacynotice");

	}

	@RequestMapping("/conditionsofsale")
	public ModelAndView showCondition() {
		System.out.println("In Conditions of Sale page");
		return new ModelAndView("conditionsofsale");

	}

	@RequestMapping("/cancelpolicy")
	public ModelAndView showCancelPolicy() {
		System.out.println("In Cancel&Return Policy page");
		return new ModelAndView("cancelpolicy");

	}

	@RequestMapping("/images")
	public ModelAndView showImages() {
		System.out.println("In images home page");
		ModelAndView mv= new ModelAndView("home"); 
		mv.addObject("signinmsg","please Sign In to continue...");
		return mv;

	}
	
	@RequestMapping("/productsuser")
	public ModelAndView viewItems() throws JsonGenerationException, JsonMappingException, IOException {
		List<Product> list = productDAO.list();
		System.out.println("product list=" + list);
		ObjectMapper om = new ObjectMapper();
		String listjson = om.writeValueAsString(list);
		System.out.println(listjson);
		return new ModelAndView("productsuser", "listofitem", listjson);
	}
	
	String setName;
	List<Product> plist;

	@SuppressWarnings("unchecked")
	@RequestMapping("/GsonCon")
	public @ResponseBody String getValues() throws Exception {
		String result = "";
		plist = productDAO.list();
		Gson gson = new Gson();
		result = gson.toJson(plist);
		return result;

	}
	
}
 