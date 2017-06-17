package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int cartId;
private double grandTotal;
private String paymentMode;

@OneToOne
@JoinColumn(name="customer_id")
private Customer customer;



public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public double getGrandTotal() {
	return grandTotal;
}
public void setGrandTotal(double grandTotal) {
	this.grandTotal = grandTotal;
}

public String getPaymentMode() {
	return paymentMode;
}
public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
}



}
