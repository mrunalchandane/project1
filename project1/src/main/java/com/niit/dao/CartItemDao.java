package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemDao {

	List<CartItem> getMyCartItems(int cartId);

	CartItem getCartItemByProductId(int productId);

	void updateCartItem(CartItem cartItem);

	void addCartItem(CartItem cartItem);

	void deleteCartItem(CartItem cartItemByProductId);

	void deleteAllCartItems(int cartId);

}
