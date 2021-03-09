package com.myapp.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.Add_Prod_Tocart;

@Repository
public class Add_Prod_Fields_impl implements Add_Prod_Fields {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Add_Prod_Tocart saveOrders(Add_Prod_Tocart aptc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Add_Prod_Tocart updateOrdersCategory(Add_Prod_Tocart aptc) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into orders values (Username)", aptc.getId(), aptc.getCategory(), aptc.getType(),
				aptc.getName(), aptc.getBrand(), aptc.getQuantity(), aptc.getPrice(), aptc.getExpiry_Date(),
				aptc.getCount());

		return null;
	}

	@Override
	public Add_Prod_Tocart updateOrdersType(Add_Prod_Tocart aptc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Add_Prod_Tocart updateOrdersName(Add_Prod_Tocart aptc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Add_Prod_Tocart updateOrdersCount(Add_Prod_Tocart aptc) {
		// TODO Auto-generated method stub
		return null;
	}

}
