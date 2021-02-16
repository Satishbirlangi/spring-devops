package com.myapp.spring.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="newproducts")

public class Product {

	private Integer productId;
	
	private String ProductName;
	
	private Double Price;
	
	private String description;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(String productName, Double price, String description) {
		ProductName = productName;
		Price = price;
		this.description = description;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public Double getPrice() {
		return Price;
	}


	public void setPrice(Double price) {
		Price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
}
