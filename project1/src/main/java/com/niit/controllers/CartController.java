package com.niit.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@SuppressWarnings("deprecation")
@Controller
public class CartController {
	@Autowired
	private CartService cartService;
		
	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CustomerService customerService;

	
	@RequestMapping("/cart")
	public String getAllproducts(Model model, Principal activeUser) {
		System.out.println("fetching cart in  cartcontroller");

		Customer user = customerService.getCustomerByName(activeUser.getName());
		System.out.println("generating cart for cartid = "+user.getCart().getCartId());
		try {
			List<CartItem> list = cartItemService.getMyCartItems(user.getCart().getCartId());

			if (list.isEmpty()) {
				model.addAttribute("msg", "No item found in your cart");
				System.out.println("Going to cart page");
				model.addAttribute("cart", true);
				return "cart";
			} else {
				ArrayList<Integer> productIdlist = new ArrayList<Integer>();
				List<Product> productInCartDetails = new ArrayList<Product>();
				Cart cart = cartService.getCart(user.getCustomerId());
				System.out.println("got cart");
				double subTotal = 0;
				int totalItem = 0;
				for (CartItem c : list) {

					productIdlist.add(c.getProductId());
					totalItem += c.getQuantity();
					subTotal += c.getTotalPrice();

					Product productDetails = productService.getProductById(c.getProductId());
					productDetails.setPrice((int) (c.getTotalPrice() / c.getQuantity()));
					productDetails.setQuantityperproduct(productDetails.getQuantityperproduct());
					productInCartDetails.add(productDetails);

				}

				System.out.println("subtotal = " + subTotal);
				cart.setGrandTotal(subTotal + 20.0); // subtotal + tax
				cartService.updateCart(cart);
				System.out.println("grand total  = " + cart.getGrandTotal());

				model.addAttribute("cartItems", list);
				model.addAttribute("msg", "CartItems present in the cart of " + activeUser.getName());
				model.addAttribute("subtotal", subTotal);
				model.addAttribute("totalItem", totalItem);
				model.addAttribute("grandtotal", cart.getGrandTotal());
				model.addAttribute("show", true);
				model.addAttribute("productInCart", productInCartDetails);
				
				System.out.println("Going to cart page");
				model.addAttribute("cart", true);
				return "cart";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Going to cart page");
			model.addAttribute("msg", "No item found in your cart");
			model.addAttribute("show", false);
			model.addAttribute("cart", true);
			return "cart";
		}
	}
	
	

}
