package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService{
@Autowired
private CartItemDao cartItemDao;
	
	public List<CartItem> getMyCartItems(int cartId) {
		
		return cartItemDao.getMyCartItems(cartId);
	}

	
	public CartItem getCartItemByProductId(int productId) {
		return cartItemDao.getCartItemByProductId(productId);
	}


	
	public void updateCartItem(CartItem cartItem) {
		cartItemDao.updateCartItem(cartItem);
		
	}



	public void addCartItem(CartItem cartItem) {
		
		cartItemDao.addCartItem(cartItem);
	}


	
	public void deleteCartItem(CartItem cartItemByProductId) {
		cartItemDao.deleteCartItem(cartItemByProductId);
		
	}



	public void deleteAllCartItems(int cartId) {
	     cartItemDao.deleteAllCartItems(cartId);
		
	}

}
