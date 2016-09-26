package com.niit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDAO;
import com.niit.dao.CartItemDAO;
import com.niit.dao.CategoryDAO;
import com.niit.dao.UserDAO;
import com.niit.dao.ProductDAO;
import com.niit.dao.SupplierDAO;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.User;
import com.niit.model.OrderedItems;
import com.niit.model.Product;
import com.niit.model.Supplier;
//import com.niit.viewmodel.CartItemModel;

@Controller

public class CartController {

	@Autowired
	private Product product;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private Category category;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Supplier supplier;
	
	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private User user;
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private Cart cart;
	
	@Autowired
	private CartItem cartItem;

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private CartItemDAO cartItemDAO;

	@Autowired
	HttpSession httpSession;
	


@RequestMapping("/addtocart")
public ModelAndView addToCart(@RequestParam("pro_Id")String id,Model model) {
	System.out.println("In addtocart page");
	//c.setCartItem(p.setPrice(p.getPrice()));
	//model.addAttribute("cartList", cartDAO.listOrderedItems(id));
	Product p=productDAO.get(id);
	System.out.println(id);
	productDAO.saveOrUpdate(p);
	cartItem.setProduct(p);
	cartItem.setPrice(p.getPrice());
	cartItem.setQuantity(1);
	//cartItem.setCart(c);
	cartItemDAO.save(cartItem);
	System.out.println("cart saved");
	model.addAttribute("cartList", cartItemDAO.listCartItems());
	return new ModelAndView("addtocart");
}

}

	/*@RequestMapping("/user/cart/")
	public ModelAndView viewCart(Model model, Principal userName,
			@RequestParam(value = "cartItemRemoved", required = false) String cartItemRemoved,
			@RequestParam(value = "updateSuccessfull", required = false) String updateSuccessfull,
			@RequestParam(value = "cancelUpdate", required = false) String cancelUpdate,
			@RequestParam(value = "cannotUpdate", required = false) String cannotUpdate)

	{
		ModelAndView mv = new ModelAndView("index");
		//String userName = userName.getName();
		if (cartItemRemoved != null) {
			model.addAttribute("cartItemRemoved", "Cart item removed successfully");
		}
		if (updateSuccessfull != null) {
			model.addAttribute("updateCartSuccessfull", "Quantity updated successfully");
		}
		if (cancelUpdate != null) {
			model.addAttribute("cancelUpdate",
					"Sorry, Quantity of product you are trying to update is insufficient in our stock");
		}
		if (cannotUpdate != null) {
			model.addAttribute("cannotUpdate", "Sorry, The product you are trying to update is not available");
		}
		user = userDAO.getName(userName);
		String userId = user.getUserID();

		List<CartItem> cartItems = null;
		Cart cart = cartDAO.getCartByUserId(userId);
		// When there are products in cart
		if (returnProductName(userId) != null && !returnProductName(userId).isEmpty()) {
			cartItems = returnProductName(userId);
			for (CartItemModel item : cartItems) {
				// Check whether the cart item is in stock or it not exists
				if (item.getCartItem().getProductId() == null
						|| productDAO.get(item.getCartItem().getProductId()).getQuantity() <= 0) {

					cart.setGrandTotal(cart.getGrandTotal() - item.getCartItem().getTotalPrice());
					model.addAttribute("notInStock", "Not in stock");
					cartDAO.saveOrUpdate(cart);
				}

				else {
					List<CartItem> listOfSelectedCartItems;
					// Now after getting the cartItem change grandTotal and No
					// of Products
					listOfSelectedCartItems = cartItemDAO.getCartItemsByUserId(userId);
					double grandTotal = 0;
					for (CartItem item1 : listOfSelectedCartItems) {
						// Also check is there any item which should not be
						// considered
						String productId = item1.getPro_Id();
//						check whether the product is present or not in database
						if (productId != null) {
							if (productDAO.get(productId).getQuantity() == 0
									|| item1.getQuantity() > productDAO.get(item1.getPro_Id()).getQuantity())
								grandTotal = grandTotal;
							else {
								grandTotal = grandTotal + item1.getTotalPrice();
							}
						}
					}
					cart.setGrandTotal(grandTotal);

					int noOfProducts = listOfSelectedCartItems.size();

					cart.setNoOfProducts(noOfProducts);
					cartDAO.saveOrUpdate(cart);
				}
			}

			mv.addObject("cartItems", cartItems);
			double grandTotal = cartDAO.getCartByUserId(userId).getGrandTotal();
			if (grandTotal > 0)
				mv.addObject("grandTotal", grandTotal);
			else
				model.addAttribute("zeroGrandTotal", "Product not present");
		}
		// When there are no products in cart
		else {
			model.addAttribute("cartEmpty", "No items present in the cart");

			mv.addObject("noOfProducts", 0);
		}

		// Gets the category on the navber
		List<Category> categoryList = categoryDAO.list();
		mv.addObject("categoryList", categoryList);
		// ================================================================

		mv.addObject("isClickedViewCart", true);
		mv.addObject("displayCart", "true");
		mv.addObject("activeNavMenu", "viewCart");

		return mv;
	}

	// Method to get name of product
	public List<CartItem> returnProductName(String userId) {

		List<CartItem> cartItems = cartItemDAO.getCartItemsByUserId(userId);

		List<CartItem> cartItemModelList = new ArrayList<>();

		CartItem cartItemModel = null;

		for (CartItem item : cartItems) {
			cartItemModel = new CartItem();
			cartItemModel.setCartItem(item);
			if (item.getPro_Id() != null && !item.getPro_Id().isEmpty()) {
				product = productDAO.get(item.getPro_Id());
				cartItemModel.setProductName(product.getProductName());
			} else {
				cartItemModel.setProductName("Currently not avilable");
			}
			cartItemModelList.add(cartItemModel);
		}
		return cartItemModelList;
	}

	@RequestMapping("/user/cart/addToCart/{productId}")
	public String addToCart(@PathVariable("productId") String productId, Model model, Principal userName) {

		// System.out.println(name);

		// 1.Get the user id by its user name
		String userName = userName.getName();
		user = userDAO.getName(userName);
		String userId = user.getUserID();

		// 2.Check whether his cart is present in the cart table
		// If cart is not present then make a cart for him

		if (cartDAO.getCartByUserId(userId) == null) {
			cart = new Cart();
			cart.setUserId(userId);
			cartDAO.saveOrUpdate(cart);

			// cartItem.setCartId(cart.getCartId());
		}

		// This statement changes the cart if cart is present and due to
		// unpresence of this there where errors
		else {
			cart = cartDAO.getCartByUserId(userId);
		}

		String cartId = cart.getCartId();

		// 3.get the product price

		product = productDAO.get(productId);

		// If cart is present then go into the cartItem table and search for
		// product
		// this user selected whether it exists or it is a new product.
		// -------------
		// passing the userId and productId to a method name returnCartItem
		// through a method

		// if we get null means the product is not present
		// String
		// redirectPage="redirect:/productDetail/{productId}?addToCartSuccessMessage";
		String redirectPage = null;
		int codeRecieved = addCartItem(userId, productId, cartId);
		switch (codeRecieved) {
		case 0: {
			cartItem = new CartItem();
			cartItem.setCartID(cartId);
			cartItem.setUserID(userId);
			cartItem.setPro_Id(product.getPro_Id());
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getPrice());
			cartItemDAO.saveOrUpdate(cartItem);
			System.out.println("Insertion of cartItem");
			updateCartAgain(cartId, userId);
			redirectPage = "redirect:/productDetail/{productId}?addToCartSuccessMessage";
			break;
		}
		case 1:
			redirectPage = "redirect:/productDetail/{productId}?cancelledAddToCart";
			break;
		case 2:
			redirectPage = "redirect:/productDetail/{productId}?addToCartSuccessMessage";
		}
		httpSession.setAttribute("noOfProducts", returnNoOfProducts(userId));
		// Now navigate to the same page
		return redirectPage;
	}

	// This function will update the cart
	public int updateCartAgain(String cartId, String userId) {

		List<CartItem> listOfSelectedCartItems;
		// Now after getting the cartItem change grandTotal and No of Products
		listOfSelectedCartItems = cartItemDAO.getCartItemsByUserId(userId);
		double grandTotal = 0;
		for (CartItem item : listOfSelectedCartItems) {
			grandTotal = grandTotal + item.getTotalPrice();
		}
		cart.setGrandTotal(grandTotal);

		int noOfProducts = listOfSelectedCartItems.size();

		cart.setCartId(cartId);
		cart.setUserId(userId);
		cart.setNoOfProducts(noOfProducts);
		cartDAO.saveOrUpdate(cart); // This method updates the cart

		return noOfProducts;
		// =========== Completed Adding the item to cart =====

	}

	// This is the method which perform all the operations related to addition
	// of product cartItem
	public int addCartItem(String userId, String productId, String cartId) {

		List<CartItem> listOfSelectedCartItems = cartItemDAO.getCartItemsByUserId(userId);
		Product product = productDAO.get(productId);
		for (CartItem item : listOfSelectedCartItems) {
			String itemProductId = item.getPro_Id();
			System.out.println(itemProductId);
			if (itemProductId != null) {
				if (itemProductId.equals(product.getPro_Id())) {
					System.out.println(item.getCartItemId());
					item.setCartItemId(item.getCartItemId());

					System.out.println(item.getQuantity());
					// Check the whether the user is adding the item to cart
					// more
					// than its quantity
					if (item.getQuantity() >= product.getQuantity()) {
						return 1; // This is a code which denotes product is
									// not enough to added to his cart as its
									// present

						 "redirect:/productDetail/{productId}?cancelledAddToCart"; 
					} else {
						item.setQuantity(item.getQuantity() + 1);

						System.out.println(item.getTotalPrice());
						item.setTotalPrice(item.getTotalPrice() + product.getPrice());

						System.out.println(item.toString());
						cartItemDAO.saveOrUpdate(item);
						updateCartAgain(cartId, userId);
						return 2; // This is a code which denotes product added
									// to
									// cart successfully
						 "redirect:/productDetail/{productId}?addToCartSuccessMessage"; 
					} // ---else ends
				} // ----- outer if ends -----
			} // --- if to manage whether the product exist or not
		} // ----- for loop ends
			// ------- If ends
		return 0; // Product is not present in cart we need to generate a new
					// one
	}

	// To remove the cart items one by one from the cart
	@RequestMapping("/user/cart/remove/{cartItemId}")
	public String removeCartItems(@PathVariable("cartItemId") String cartItemId, Model model, Principal username) {
		cartItem = cartItemDAO.getCartItem(cartItemId);
		String userId = cartItem.getUserID();
		String cartId = cartItem.getCartID();
		cartItemDAO.delete(cartItemId);
		int noOfProducts = updateCartAgain(cartId, userId);
		model.addAttribute("noOfProducts", noOfProducts);
		httpSession.setAttribute("noOfProducts", returnNoOfProducts(userId));
		return "redirect:/user/cart/?cartItemRemoved";
	}

	// This is the method to count cart items
	public int returnNoOfProducts(String userId) {
		if (userId != null) {
			int noOfProduct = cartDAO.getCartByUserId(userId).getNoOfProducts();
			return noOfProduct;
		}
		return 0;
	}

	// To get the listOf ordered items
	@RequestMapping("/user/cart/history")
	public ModelAndView listOrderedItems(Principal principal, Model model) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("isViewHistoryclicked", "true");
		user = userDAO.getUserByUserName(principal.getName());

		List<OrderedItems> listofOrderedItems = cartDAO.listOrderedItems(user.getUserID());
		if (listofOrderedItems != null && !listofOrderedItems.isEmpty()) {
			model.addAttribute("listOfOrderedItems", listofOrderedItems);
		} else {
			model.addAttribute("noProductsinHistory", "No products ordered till now");
		}
		mv.addObject("activeNavMenu", "viewCart");
		return mv;

	}

	// Add a product to cart on all products page
	@RequestMapping("/user/allProducts/addToCart/{productId}")
	public String addToCartForAllProducts(@PathVariable("productId") String productId, Model model,
			Principal userName) {

		// System.out.println(name);

		// 1.Get the user id by its user name
		String userName = userName.getName();
		user = userDAO.get(userName);
		String userId = user.getUserID();

		// 2.Check whether his cart is present in the cart table
		// If cart is not present then make a cart for him

		if (cartDAO.getCartByUserId(userId) == null) {
			cart = new Cart();
			cart.setUserId(userId);
			cartDAO.saveOrUpdate(cart);

			// cartItem.setCartId(cart.getCartId());
		}

		// This statement changes the cart if cart is present and due to
		// unpresence of this there where errors
		else {
			cart = cartDAO.getCartByUserId(userId);
		}

		String cartId = cart.getCartId();

		// 3.get the product price

		product = productDAO.get(productId);

		// If cart is present then go into the cartItem table and search for
		// product
		// this user selected whether it exists or it is a new product.
		// -------------
		// passing the userId and productId to a method name returnCartItem
		// through a method

		// if we get null means the product is not present

		String redirect = null;
		int codeRecieved = addCartItem(userId, productId, cartId);
		switch (codeRecieved) {
		case 0: {
			cartItem = new CartItem();
			cartItem.setCartID(cartId);
			cartItem.setUserID(userId);
			cartItem.setPro_Id(product.getPro_Id());
			cartItem.setQuantity(1);
			cartItem.setTotalPrice(product.getPrice());
			cartItemDAO.saveOrUpdate(cartItem);
			System.out.println("Insertion of cartItem");
			updateCartAgain(cartId, userId);
			redirect = "redirect:/allProducts?addToCartAllProducts";
			break;
		}
		case 1:
			redirect = "redirect:/allProducts?cancelledAddToCart";
			break;
		case 2:
			redirect = "redirect:/allProducts?addToCartAllProducts";

		}
		httpSession.setAttribute("noOfProducts", returnNoOfProducts(userId));
		// Now navigate to the same page
		return redirect;
	}

	// To update the cart quantity
	@RequestMapping("/user/cart/update")
	public String updateCartItemQuantity(@RequestParam(value = "cartItemId") String cartItemId,
			@RequestParam(value = "cartQuantity") int quantity) {
		String redirect = null;
		cartItem = cartItemDAO.getCartItem(cartItemId);

		String productId = cartItem.getPro_Id();
//		check whether the product is present or not in database
		if (productId != null) {
			product = productDAO.get(cartItem.getPro_Id());
			int productQuantity = product.getQuantity();
			// Check whether the cartItem quantity is more or enough
			if (quantity > product.getQuantity()) {
				redirect = "redirect:/user/cart/?cancelUpdate";
			} 
				 * else if (quantity > 5) { redirect =
				 * "redirect:/user/cart/?maxCartItem"; }
				  else {
				cartItem.setQuantity(quantity);
				cartItem.setTotalPrice(quantity * product.getPrice());
				cartItemDAO.saveOrUpdate(cartItem);
				updateCartAgain(cartItem.getCartID(), cartItem.getUserID());
				redirect = "redirect:/user/cart/?updateSuccessfull";
			}
		}
		else{
			 redirect = "redirect:/user/cart/?cannotUpdate";
		}
		return redirect;
	}

}
*/