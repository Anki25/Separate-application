package com.niit.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;
import com.niit.model.User;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	User user;
	
	@RequestMapping("/signin")
	public ModelAndView SignInPage() {
		System.out.println("In SignIn page");

		return new ModelAndView("signin");

	}

	
	@RequestMapping("/check")
	public ModelAndView login(@RequestParam("txtname")String userID,@RequestParam("txtpass")String password,HttpSession session){
        log.debug("Starting of the method login");
        log.info("userID is {} password is {}",userID,password);
        
        System.out.println("In validate sign in page "+userID+" "+password);
        
        ModelAndView mv=new ModelAndView("home");; 
        //boolean isValidUser=  userDAO.isValidUser(userID,password);
        
        if(userDAO.isValidUser(userID,password) == true){
        	user=userDAO.get(userID);
        	session.setAttribute("loggedInUser", user.getFirstname());
        	session.setAttribute("loggedInUserID", user.getUserID());
        	
        	session.setAttribute("User", user);
        	
        	if(user.getRole().equals("ADMIN")){
        		mv.addObject("isAdmin", "true");
        		session.setAttribute("supplier",supplier);
        		session.setAttribute("supplierList",supplierDAO.list());
        		
        		session.setAttribute("category",category);
        		session.setAttribute("categoryList",categoryDAO.list());
        		
           	}
        	else{
        		//mv.addObject("isAdmin", "false");
        		/*cart=cartDAO.get(UserID);
        		mv.addObject("cart", cart);
        		//Fetch the cartList based on USERID
        		mv.addObject("cartList", cartList);
        		mv.addObject("cartSize", cartList.size());*/
              	}        		
        	}else{
        		mv.addObject("invalidCredentials", "true");
        		mv.addObject("errorMessage", "Invalid Credentials");
        }
        log.debug("Ending of method login");
        return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView("home");
		session.invalidate();
		session=request.getSession(true);
		session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());
		
		mv.addObject("logOutMessage", "You have successfully logged out!");
		mv.addObject("loggedout","true");
		
		return mv;
}
	
	@RequestMapping("/signup")
	public ModelAndView SignUp(@Valid @ModelAttribute("us") User u, BindingResult result, HttpServletRequest request)
			throws IOException {
		System.out.println("signup");
		return new ModelAndView("signup");
	}

	@RequestMapping("/validate")
	public ModelAndView ValidateSignUpPage(@Valid @ModelAttribute("us") User u, BindingResult result,
			HttpServletRequest request) throws IOException {
		System.out.println("In SignUp page");
		u.setRole("USER");

		System.out.println(u.getPassword());
		System.out.println(u.getCpassword());
		
		if (u.getCpassword().equals(u.getPassword())) {
			userDAO.saveOrUpdate(u);
		}
		return new ModelAndView("signin");

	}


}