package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;
import com.niit.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

@Autowired
private SessionFactory sessionFactory;
	
	public List<CartItem> getMyCartItems(int cartId) {
		String hql="from CartItem where cartID = " + "'" + cartId + "'";
		
		@SuppressWarnings({ "rawtypes" })
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<CartItem> list=query.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("No item found with this CartID in  CartItemDaoImpl");
			return null;
		}
		else
		{
			System.out.println(list.size()+" items found with this CartID in CartItemDaoImpl ");
			
			return list;
		}
	}


	public CartItem getCartItemByProductId(int productId) {
		String hql="from CartItem where productID = " + "'" + productId + "'";
		
		@SuppressWarnings({ "rawtypes" })
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings({ "unchecked" })
		List<CartItem> list=query.list();
		if(list==null || list.isEmpty())
		{
			System.out.println("No item found with this productID in CartItemDaoImpl");
			return null;
		}
		else
		{
			return list.get(0);
		}
	}


	public void updateCartItem(CartItem cartItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(cartItem);
			session.flush();
			System.out.println("CartItem successfully updated");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while updating CartItem in CartItemDaoImpl");
			
			e.printStackTrace();
		}
		
	}

	public void addCartItem(CartItem cartItem) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(cartItem);
			session.flush();
			System.out.println("CartItem successfully added in CartItemDaoImpl");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while adding CartItem in CartItemDaoImpl");
			
			e.printStackTrace();
		}
		
	}
	
	public void deleteCartItem(CartItem cartItem) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.delete(cartItem);
			session.flush();
			
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("error while deleting  cartItem in CartItemDaoImpl");
			e.printStackTrace();
			session.flush();
			
		}
	}

	public void deleteAllCartItems(int cartId) {
			Session session=sessionFactory.getCurrentSession();
			try
			{
				String hql="from CartItem where cartID = '" + cartId + "'";
		
				@SuppressWarnings({ "rawtypes" })
				Query query=sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings({ "unchecked" })
				List<CartItem> list=query.list();
				for(CartItem c:list){
					deleteCartItem(c);
				}
				session.flush();
			
			} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("error while deleting  cartItems from the Cart");
			e.printStackTrace();
			session.flush();
			}
		
	}
	
}

		

