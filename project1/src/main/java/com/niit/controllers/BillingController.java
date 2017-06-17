package com.niit.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.ShippingAddress;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Product;
import com.niit.model.BillingAddress;
import com.niit.model.Customer;
import com.niit.service.BillingService;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;
import com.niit.service.ShippingService;

@Controller
public class BillingController {
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	
		
	
	@RequestMapping ("/billing")
	public String billingAddress(Model model, Principal activeUser){
		Customer user = customerService.getCustomerByName(activeUser.getName());
		System.out.println("The active user is" + user);
		BillingAddress billingAddressList = billingService.getBillingAddressById(user.getBillingAddress().getBillingId());
		model.addAttribute("billingAddressList",billingAddressList);
		model.addAttribute("customername",activeUser.getName());
		return "billing";
	}
	
	@RequestMapping ("/shipping")
	public String shippingAddress(Model model, Principal activeUser){
		Customer user = customerService.getCustomerByName(activeUser.getName());
		ShippingAddress shippingAddressList = shippingService.getShippingAddressById(user.getShippingAddress().getShippingId());	
		model.addAttribute("shippingAddressList",shippingAddressList);
		model.addAttribute("customername",activeUser.getName());
		return "shipping";
	}
	
	@RequestMapping("/paymentDetails")
	public String checkout(Model model,Principal activeUser)
	{		
		Customer user = customerService.getCustomerByName(activeUser.getName());
		Cart cart=cartService.getCart(user.getCustomerId());
		
		cartService.updateCart(cart);
		
		model.addAttribute("msg", "going to payment method");
		model.addAttribute("payment",true);
		
		return "paymentDetails";
	}
	
	@RequestMapping ("/receipt")
	public String receipt(@RequestParam("paymentMode") String paymentMode,Model model,Principal activeUser){
		System.out.println("going on receipt page");	
		model.addAttribute("username", activeUser.getName());
		
		Cart cart=cartService.getCart(customerService.getCustomerByName(activeUser.getName()).getCustomerId());
		cart.setPaymentMode(paymentMode);
		
		
	//	model.addAttribute("receipt", true);
	//	model.addAttribute("totalproducts",HomeController.count);
		
		 
		Customer customer = customerService.getCustomerByName(activeUser.getName());

			List<CartItem> list = cartItemService.getMyCartItems(customer.getCart().getCartId());

			List<Product> productInCartDetails = new ArrayList<Product>();
				cart = cartService.getCart(customer.getCustomerId());
				double subTotal = 0,delivery=49.99;
				int totalItem = 0;
				for (CartItem c : list) {

					totalItem += c.getQuantity();
					subTotal += c.getTotalPrice();

					Product productDetails = productService.getProductById(c.getProductId());
					productDetails.setPrice((int) (c.getTotalPrice() / c.getQuantity()));
					productInCartDetails.add(productDetails);

				}
             	cart.setGrandTotal(subTotal+delivery);
             	cartService.updateCart(cart);
    			
             	model.addAttribute("paymentMode", cart.getPaymentMode());
				model.addAttribute("cartItems", list);
				model.addAttribute("subtotal", subTotal);
				model.addAttribute("delivery", delivery);
				model.addAttribute("totalItem", totalItem);
				model.addAttribute("grandtotal", cart.getGrandTotal());
				model.addAttribute("productInCart", productInCartDetails);
				//model.addAttribute("totalproducts",HomeController.count);
			
				BillingAddress billingAddress=billingService.getBillingAddressById(customer.getBillingAddress().getBillingId());
				ShippingAddress shippingAddress=shippingService.getShippingAddressById(customer.getShippingAddress().getShippingId());
				
				model.addAttribute("b", billingAddress);
				model.addAttribute("sa", shippingAddress);
				
				DateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
				Date date = new Date();
				model.addAttribute("date",dateFormat.format(date)); //2016/11/16 12:08:43
				System.out.println("Date on receipt is : "+dateFormat.format(date));

				//clear cart
				//cartItemService.deleteAllCartItems(customer.getCart());
				
				
		return "receipt";
	}
	
	
	@RequestMapping ("/thanks")
	public String thanks(Model model, Principal activeUser){
		Customer user = customerService.getCustomerByName(activeUser.getName());
		int cartId=user.getCart().getCartId();
		//clear cart
		cartItemService.deleteAllCartItems(cartId);
		return "thanks";
	}
	
}

