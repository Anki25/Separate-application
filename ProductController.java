package com.niit.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;

@Controller
public class ProductController {
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	Category category;
	
	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/addproduct") // , method=RequestMethod.POST)
	public ModelAndView showAddProduct(@Valid @ModelAttribute("prod") Product p1, BindingResult result,
			HttpServletRequest request,HttpSession session) throws IOException {
		
		session.setAttribute("supplier",supplier);
		session.setAttribute("supplierList",supplierDAO.list());
		
		session.setAttribute("category",category);
		session.setAttribute("categoryList",categoryDAO.list());
		System.out.println("In add product page");
		return new ModelAndView("addproduct");

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/registerP")
	public String createProduct(@ModelAttribute("prod") Product p2, @RequestParam("image") MultipartFile file,@RequestParam("img") MultipartFile file1,
			Model model, HttpServletRequest request) throws IOException {
		productDAO.saveOrUpdate(p2);
		
		System.out.println("image");
		MultipartFile image = p2.getImage();
		Path path;
		path = Paths.get("F://Single//Single//src//main//webapp//resources//images//" + p2.getPro_Id() + ".jpg");
		System.out.println("Path = " + path);
		System.out.println("File name = " + p2.getImage().getOriginalFilename());
		
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("First Image Saved in:" + path.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("First Image not saved");
			}
		}
		
		System.out.println("second image");
		MultipartFile img = p2.getImg();
		Path path1;
		path1 = Paths.get("F://Single//Single//src//main//webapp//resources//images//" + p2.getProd_ID() + ".jpg");
		
		if (img != null && !img.isEmpty()) {
			try {
				img.transferTo(new File(path1.toString()));
				System.out.println("Second Image Saved in:" + path1.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Second Image not saved");
			}
		}
		Supplier supplier = supplierDAO.getName(((Supplier) product.getSupplier()).getSup_name());
		supplierDAO.saveOrUpdate(supplier);

		Category category = categoryDAO.getName(product.getCategory().getCat_name());
		categoryDAO.saveOrUpdate(category);

		product.setCategory(category);
		product.setSupplier((Set<Supplier>) supplier);

		productDAO.saveOrUpdate(product);

		return "adminhome";
	}

		
}
