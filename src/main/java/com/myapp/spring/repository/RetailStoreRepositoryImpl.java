package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.RetailStore;

@Repository // It's a data Repository Class
public class RetailStoreRepositoryImpl implements RetailStoreRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<RetailStore> findAll() {
		// TODO Auto-generated method stub
		// return null;
		return jdbcTemplate.query("select * from retail_store", new BeanPropertyRowMapper<>(RetailStore.class));
	}

	@Override
	public List<RetailStore> findByCategory(String Category) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from retail_store where Category=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category);
	}

	@Override
	public List<RetailStore> findByType(String Category, String Type) {

		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from retail_store where Category=? and Type=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type);
	}

	@Override
	public List<RetailStore> findByName(String Category, String Type, String Name) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from retail_store where Category=? and Type=? and Name=?",
				new BeanPropertyRowMapper<>(RetailStore.class), Category, Type, Name);

	}

}
