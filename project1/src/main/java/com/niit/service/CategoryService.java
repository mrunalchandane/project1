package com.niit.service;

import java.util.List;

import com.niit.model.Category;

public interface CategoryService {
void saveCategory(Category category);
List<Category> getAllCategories();
}
