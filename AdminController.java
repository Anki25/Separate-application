package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class AdminController {
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;	
	
    @Autowired
    Category category;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/manageproduct")
	public ModelAndView products(@ModelAttribute("prod") Product p1, BindingResult result){
		//Category category = new Category();
		ModelAndView mv=new ModelAndView("/product");
		mv.addObject("product",product);
		mv.addObject("productList",productDAO.list());
		mv.addObject("categoryList",categoryDAO.list());
		mv.addObject("supplierList",supplierDAO.list());
		return mv;
	}
	
	@RequestMapping("/managecategory")
	public ModelAndView categories(){
		//Category category = new Category();
		ModelAndView mv=new ModelAndView("/category");
		mv.addObject("category",category);
		mv.addObject("categoryList",categoryDAO.list());
		return mv;
	}
	
	@RequestMapping("/managesupplier")
	public ModelAndView suppliers(){
		//Category category = new Category();
		ModelAndView mv=new ModelAndView("/supplier");
		mv.addObject("supplier",supplier);
		mv.addObject("supplierList",supplierDAO.list());
		return mv;
	}
	
	
	
}