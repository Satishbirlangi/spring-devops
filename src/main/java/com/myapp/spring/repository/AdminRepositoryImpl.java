package com.myapp.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myapp.spring.model.UserData;

@Repository
public class AdminRepositoryImpl implements AdminRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserData saveDetails(UserData admindata) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into admincredentials(Username, Password) values (?,?)", admindata.getUsername(),
				admindata.getPassword());
		return admindata;
	}

	@Override
	public UserData findByUnameandPwd(String Username, String Password) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select * from admincredentials where Username=? and Password=?",
				new BeanPropertyRowMapper<>(UserData.class), Username, Password);

	}

}