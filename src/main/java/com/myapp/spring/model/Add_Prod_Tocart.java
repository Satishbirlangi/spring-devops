package com.myapp.spring.model;

import java.util.Date;

public class Add_Prod_Tocart {
	private String Username;
	private int Id;
	private String Category;
	private String Type;
	private String Name;
	private String Brand;
	private String Quantity;
	private int Price;
	private Date Expiry_Date;
	private int Count;

	public Add_Prod_Tocart(String username, int id, String category, String type, String name, String brand,
			String quantity, int price, Date expiry_Date, int count) {
		Username = username;
		Id = id;
		Category = category;
		Type = type;
		Name = name;
		Brand = brand;
		Quantity = quantity;
		Price = price;
		Expiry_Date = expiry_Date;
		Count = count;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getQuantity() {
		return Quantity;
	}

	public void setQuantity(String quantity) {
		Quantity = quantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public Date getExpiry_Date() {
		return Expiry_Date;
	}

	public void setExpiry_Date(Date expiry_Date) {
		Expiry_Date = expiry_Date;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}

}
