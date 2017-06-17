package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int productId;
@NotEmpty(message="Product name is mandatory")
private String name;
@NotEmpty(message="Manufacturer details is mandatory")
private String manufacturer;
@Min(value=100,message="Minimum price should be 100")
private double price;
@Min(value=10,message="unit in stock minimum value is 10")
private int unitInStock;
@NotEmpty(message="Description is mandatory")
private String description;

private int quantityperproduct;


@ManyToOne
@JoinColumn(name="cid")
private Category category;
@Transient
private MultipartFile image; /// configure bean for this in dispatcher-servlet and add jar files common upload and 
// due to this images in the web-inf/images  will be uploaded with product name automatically
// we dont want to persist image i.e. to be not stored in the table in product so we add annotation @Transient so it will ignore this property


public String getDescription() {
	return description;
}
public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
public void setDescription(String description) {
	this.description = description;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}

public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getUnitInStock() {
	return unitInStock;
}
public void setUnitInStock(int unitInStock) {
	this.unitInStock = unitInStock;
}
public int getQuantityperproduct() {
	return quantityperproduct;
}
public void setQuantityperproduct(int quantityperproduct) {
	this.quantityperproduct = quantityperproduct;
}



}
