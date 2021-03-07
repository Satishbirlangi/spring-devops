package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.repository.AdminRepository;

@RestController
@RequestMapping("/admincredentials")
public class Adminlogin {

	@Autowired

	private AdminRepository adminrepo;

	@GetMapping("/admincredentials")
	public String AdminUI() {
		return adminrepo.AdminUI();
	}

	@GetMapping("adminCRedentials/{Username}/{Password}")
	public String findByAdminCredentials(@PathVariable("Username") String Username,
			@PathVariable("Password") String Password) {
		return adminrepo.findByAdminCredentials(Username, Password);
	}

}
