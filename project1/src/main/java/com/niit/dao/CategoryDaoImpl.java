package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao{
@Autowired
private SessionFactory sessionFactory;
	
	public List<Category> getAllCategories() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		@SuppressWarnings("unchecked")
		List<Category> categories=query.list();
		session.close();
		return categories;
	}

	 public void saveCategory(Category category){
		   Session session=sessionFactory.openSession();
		   System.out.println("Category ID BEFORE INSERTION" +category.getCid());
		   session.save(category);
		   System.out.println("Category ID AFTER INSERTION" +category.getCid());
		   session.flush();
		   session.close();
	   }
}
