package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Controller
public class CartController {

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private Cart cart;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	HttpSession httpSession;
	
/*@RequestMapping("/addtocart")
public ModelAndView addToCart(@RequestParam("pro_Id")String id,@RequestParam("userid")String uid,Cart c,Product p,User u,Model model) {
	System.out.println("In addtocart page");
	
    p=productDAO.get(id);
    productDAO.saveOrUpdate(p);	
	
	u=userDAO.get(uid);
	userDAO.saveOrUpdate(u);
	
	c.setUser(u);
	c.setUserID(u.getUserID());
	
	c.setPrice(p.getPrice());
	c.setQuantity(1);
	
	c.setProduct(p);
	c.setPro_Id(p.getPro_Id());
	
	cartDAO.save(c);
	System.out.println("cart saved");
	model.addAttribute("cartList", cartDAO.list(uid));
	return new ModelAndView("addtocart");
}
*/
	
/*	@RequestMapping("/addtocart")
	public ModelAndView addToCart(@RequestParam("pro_Id") String id,@RequestParam("userid")String uid,Cart c,Product p,User u,Model model) {
		System.out.println("In addtocart page");
		
		p=productDAO.get(id);
	    productDAO.saveOrUpdate(p);	
		
		u=userDAO.get(uid);
		userDAO.saveOrUpdate(u);
		
		c.setUser(u);
		c.setUserID(u.getUserID());
		
		c.setProduct(p);
		c.setPro_Id(p.getPro_Id());
		
				
		if(c.getPro_Id()==null){
			c.setQuantity(1);
		c.setPrice(p.getPrice());
				
		cartDAO.save(c);
		System.out.println("cart saved");
		
		}
		
		else{
			System.out.println("Updating cart");
			c.setQuantity(c.getQuantity()+1);
			c.setPrice(p.getPrice()*c.getQuantity());
			System.out.println("Updating cart finished");
			cartDAO.update(c);
		
		}
		model.addAttribute("cartList", cartDAO.list(uid));

		return new ModelAndView("addtocart");	
	}

	*/
	
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/buy{id}&{pid}", method = RequestMethod.POST)
	public ModelAndView buyproductPage(@PathVariable("id") String id, @PathVariable("pid") String pid,
			@RequestParam("quantity") String quantity, HttpSession session) throws Exception {

	ModelAndView mv = new ModelAndView("addtocart");
	int k = Integer.parseInt(quantity);
	int y = 0;
	Cart kcart = new Cart();
	for (Cart temp : cartDAO.mycartproducts(id)) {
		if (temp.getPro_Id().equals(pid)) {
			y = 1;
			kcart = temp;
		}
	}
	if (y == 1) {
		kcart.setQuantity(kcart.getQuantity() + k);
		kcart.setPrice(kcart.getQuantity() * kcart.getProduct().getPrice());
		cartDAO.update(kcart);
	} else {
		cart.setQuantity(k);
		cart.setUserID(id);
		cart.setPro_Id(pid);
		cart.setUser(userDAO.get(id));
		product = productDAO.get(pid);
		cart.setProduct(product);
		cart.setPrice(cart.getQuantity() * product.getPrice());
		cartDAO.save(cart);
	}
	mv.addObject("cartList", cartDAO.list(id));
	return mv;
}
	
	
	
	
	
	
	
	
	
	
@RequestMapping("/viewcart/{userid}")
public ModelAndView viewCart(@RequestParam("userid")String uid,Model model) {
	System.out.println("viewing cart");
	
	model.addAttribute("cartList", cartDAO.list(uid));
	return new ModelAndView("addtocart");
}

@RequestMapping("remove")
public ModelAndView deleteCart(@RequestParam("id")String pid,@RequestParam("usid")String uid,Cart ca,Model model) {
	System.out.println("deleting cart item");
	
	ca=cartDAO.get(pid, uid);
	if (ca == null) {
		model.addAttribute("errorMessage", "Could not delete");
	} else {	
	cartDAO.delete(pid, uid);
	model.addAttribute("cartList", cartDAO.list(uid));
	}
	System.out.println("deleted");
	return new ModelAndView("addtocart");
}

}

	