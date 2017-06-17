package com.niit.service;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemService {

	List<CartItem> getMyCartItems(int cartId);

	CartItem getCartItemByProductId(int productId);

	void updateCartItem(CartItem cartItem);

	void addCartItem(CartItem cartItem);

	void deleteCartItem(CartItem cartItemByProductId);

	void deleteAllCartItems(int cartId);

}
