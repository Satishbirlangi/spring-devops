package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.repository.AdminRepository;

@RestController
@RequestMapping("/AdminCredentials")
public class Adminlogin {

	@Autowired

	private AdminRepository adminrepo;

	@GetMapping("/AdminCredentials")
	public String AdminUI() {
		return adminrepo.AdminUI();
	}

	@GetMapping("AdminCRedentials/{Username}/{Password}")
	public String findByAdminCredentials(@PathVariable String Username, @PathVariable String Password) {
		return "success";
	}

}
