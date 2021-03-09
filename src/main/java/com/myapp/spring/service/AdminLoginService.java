package com.myapp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.spring.model.AdminData;
import com.myapp.spring.repository.AdminLoginRepository;

@Service("adminloginservice")
public class AdminLoginService {

	@Autowired(required = true)
	AdminLoginRepository repo;

	public boolean validateUser(AdminData userInputData) {
		AdminData userData = repo.validateLoggedInAdmin(userInputData.getUsername());
		System.out.println("UserData::" + userData);
		if (userData != null) {
			if (userInputData.getPassword().equals(userData.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
