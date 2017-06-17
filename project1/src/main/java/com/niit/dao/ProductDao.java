package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
void saveOrUpdateProduct(Product product);

List<Product> getAllProducts();

Product getProductById(int productId);

void deleteProduct(int productId);
}
