package com.niit.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.service.CartItemService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;



@Controller
public class CartItemController {
	
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CustomerService customerService ;
	
	

	@RequestMapping(value = "/addToCart/{productId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	 public void addToCart(@PathVariable("productId") int productId, Model model,Principal activeUser) {
       System.out.println("addToCart in  controller with productID "+productId);
        Product product=productService.getProductById(productId);
		System.out.println("Adding product to CartItem with productname = "+product.getName());
      
		Customer user=customerService.getCustomerByName(activeUser.getName());
		CartItem cartItem;
		
		int f=1;
		try {
			List<CartItem> list=cartItemService.getMyCartItems(user.getCart().getCartId());
		
			for(CartItem p:list)
			{
				if(p.getCartId()==user.getCart().getCartId()&&p.getProductId()==productId)
				{
					product.setQuantityperproduct(product.getQuantityperproduct()+1);
					System.out.println("Quantity of product increased"+product.getQuantityperproduct());
					cartItem=cartItemService.getCartItemByProductId(productId);
					cartItem.setQuantity(cartItem.getQuantity()+1);
					cartItem.setTotalPrice(cartItem.getQuantity()*product.getPrice());
					cartItemService.updateCartItem(cartItem);
					f=0;
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f==1)
		{
		product.setQuantityperproduct(1);
		cartItem=new CartItem();
		cartItem.setQuantity(1);
		cartItem.setCartId(user.getCart().getCartId());
		cartItem.setProductId(productId);
		cartItem.setTotalPrice(cartItem.getQuantity()*product.getPrice());
        cartItemService.addCartItem(cartItem);
		}
		System.out.println("CartItem inserted");
	}
	
	@RequestMapping(value = "/deleteCartItem/{productId}", method = RequestMethod.GET)
	public String deleteProductFromCart(@PathVariable(value = "productId") int productId) {
      
		 System.out.println("delete cartItem in  controller with productID "+productId);
			
		 cartItemService.deleteCartItem(cartItemService.getCartItemByProductId(productId));
      
			 System.out.println("going to cart again");
				
        return "redirect:/cart"; 
	}
	
}
