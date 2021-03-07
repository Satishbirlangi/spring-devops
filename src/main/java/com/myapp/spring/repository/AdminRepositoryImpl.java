package com.myapp.spring.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.AdminData;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String findByAdminCredentials(String Uname, String Pword) {
		// TODO Auto-generated method stub
		List adcred = jdbcTemplate.query("select * from AdminCredentials;",
				new BeanPropertyRowMapper<>(AdminData.class));
		if (adcred.contains(Uname) && adcred.contains(Pword)) {
			return "success";
		} else {
			return "Login failure";
		}

	}

	@Override
	public String AdminUI() {
		System.out.println("Welcome to Admin Page");
		return "Give Username and Password";
	}
}