package com.myapp.spring.model;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

=======
>>>>>>> 785c7c7238001745e2746387d177c9d69ce4c74c
public class RetailStore {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private Integer Id;

	private String Category;

<<<<<<< HEAD
	private String Type;

	private String Name;

	private String Brand;

	private String Quantity;

	private Integer Price;

	private String Expiry_Date;

	private Integer Stock;

	public RetailStore() {
	}

	public RetailStore(Integer Id, String Category, String Type, String Name, String Brand, String Quantity,

			Integer Price, String Expiry_Date, Integer Stock) {

		this.Id = Id;
		this.Category = Category;
		this.Type = Type;
		this.Name = Name;
		this.Brand = Brand;
		this.Quantity = Quantity;
		this.Price = Price;
		this.Expiry_Date = Expiry_Date;
		this.Stock = Stock;
	}

=======
>>>>>>> 785c7c7238001745e2746387d177c9d69ce4c74c
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
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

	public Integer getPrice() {
		return Price;
	}

	public void setPrice(Integer price) {
		Price = price;
	}

	public String getExpiry_Date() {
		return Expiry_Date;
	}

<<<<<<< HEAD
	public void setExpiry_Date(String Expiry_Date) {

		this.Expiry_Date = Expiry_Date;

=======
	public void setExpiry_Date(String expiry_Date) {
		Expiry_Date = expiry_Date;
>>>>>>> 785c7c7238001745e2746387d177c9d69ce4c74c
	}

	public Integer getStock() {
		return Stock;
	}

	public void setStock(Integer stock) {
		Stock = stock;
	}

	public RetailStore(Integer id, String category, String type, String name, String brand, String quantity,
			Integer price, String expiry_Date, Integer stock) {
		Id = id;
		Category = category;
		Type = type;
		Name = name;
		Brand = brand;
		Quantity = quantity;
		Price = price;
		Expiry_Date = expiry_Date;
		Stock = stock;
	}

	private String Type;

	private String Name;

	private String Brand;

	private String Quantity;

	private Integer Price;

	private String Expiry_Date;

	private Integer Stock;

	public RetailStore() {
	}

	public boolean validate(String Category, String Type, String Name) {

		List<RetailStore> list = jdbcTemplate.query("select * from retail_store where Category=? and Type=? and Name=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type, Name);
		boolean a = list.isEmpty();
		if (a == false) {
			return true;
		} else
			return false;

	}

}
