package com.niit.controllers;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/admin/product/productform")
	public String getProductForm(Model model){
		model.addAttribute("product",new Product());
		List<Category> categoryDetails=categoryService.getAllCategories();
		model.addAttribute("categorydetails", categoryDetails);
		return "productform";
	}
	
	
	//input is id
	//output is Product object
	@RequestMapping("/admin/product/editproduct/{productId}")
	public String editProduct(@PathVariable int productId,Model model){
		Product product=productService.getProductById(productId);
		model.addAttribute("product",product);
		List<Category> categoryDetails=categoryService.getAllCategories();
		model.addAttribute("categorydetails", categoryDetails);
		return "productform";
	}
	
	@RequestMapping("/admin/product/saveproduct")
	public String saveOrUpdateProduct(@Valid @ModelAttribute(name="product") Product product,BindingResult result){
		if(result.hasErrors()){
			System.out.println("HAS ERRORS");
			return "productform";
		}
			
		System.out.println("After Validation");
		productService.saveOrUpdateProduct(product);
		
		MultipartFile image=product.getImage();
		if(image!=null && image.isEmpty()){
		Path path=Paths.get
			("D:/MRsession/workspace/project1/src/main/webapp/WEB-INF/resources/images/"+product.getProductId()+".png");
		try
		{
		image.transferTo(new File(path.toString()));
		}catch(IllegalStateException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		}
		return "redirect:/all/product/productlist";
	}
	
	@RequestMapping("/all/product/productlist")
	public String getAllProducts(Model model){
		List<Product> products=productService.getAllProducts();
		for(Product p:products){
			System.out.println(p.getName());
			System.out.println(p.getPrice());
		}
		model.addAttribute("products",products);
		
		return "productlist";
	}

	@RequestMapping("/all/product/viewproduct/{productId}")
	public String viewProduct(@PathVariable int productId,Model model){
		Product product=productService.getProductById(productId);
		model.addAttribute("product",product);
		return "viewproduct";
	}
	@RequestMapping("/admin/product/deleteproduct/{productId}")
	public String deleteProduct(@PathVariable int id){
		productService.deleteProduct(id);
		return "redirect:/all/product/productlist";
	}
	
	
	@RequestMapping("/admin/category/categoryform")
	public String getCategoryForm(Model model)
	{
		model.addAttribute("category", new Category());
		return "categoryform";
	}
	
	@RequestMapping("/admin/category/savecategory")
	public String saveCategory(@Valid @ModelAttribute(name="category") Category category,BindingResult result){
		if(result.hasErrors()){
			System.out.println("HAS ERRORS");
			return "categoryform";
		}
		System.out.println("After Validation");
		categoryService.saveCategory(category);
		return "redirect:/all/product/productlist";
	}
		
		
	@RequestMapping("/all/product/productsByCategory")
	public String getProductsByCategory(@RequestParam(name="searchCondition") String searchCondition,
			Model model,HttpSession session){
	        session.setAttribute("categories",categoryService.getAllCategories());
		List<Product> products=productService.getAllProducts();
		//Assigning list of products to model attribute products
		model.addAttribute("products",products);
		model.addAttribute("searchCondition",searchCondition);
		return "productlist";
	}

}
