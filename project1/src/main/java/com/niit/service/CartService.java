package com.niit.service;

import com.niit.model.Cart;

public interface CartService {

	Cart getCart(int customerId);

	void updateCart(Cart cart);

}
