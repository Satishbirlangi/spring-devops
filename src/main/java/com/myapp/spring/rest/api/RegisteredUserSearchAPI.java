package com.myapp.spring.rest.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.RetailStore;
import com.myapp.spring.repository.RetailStoreRepository;

@RestController
@RequestMapping("reg_search")

public class RegisteredUserSearchAPI {
	@Autowired
	private RetailStoreRepository repository;

	@GetMapping("/{Category}")
	public List<RetailStore> findByCategoryNew(@PathVariable("Category") String category, HttpServletRequest request) {
		Object isValidUser = request.getSession().getAttribute("isAuthenticated");
		System.out.println("isValidUser:" + isValidUser);
		if (isValidUser != null) {
			if ((boolean) isValidUser) {
				System.out.println("is valid user and searching the product");
				return repository.findByCategory(category);
			}
		}
		return null;
	}

	@GetMapping("/{Category}/{Type}")
	public List<RetailStore> findByType(@PathVariable("Category") String Category, @PathVariable("Type") String Type,
			HttpServletRequest request) {
		Object isValidUser = request.getSession().getAttribute("isAuthenticated");

		System.out.println("isValidUser:" + isValidUser);
		if (isValidUser != null) {
			if ((boolean) isValidUser) {
				System.out.println("is valid user and searching the product");
				return repository.findByType(Category, Type);
			}
		}
		return null;
	}

	@GetMapping("/{Category}/{Type}/{Name}")
	public List<RetailStore> findByType(@PathVariable("Category") String Category, @PathVariable("Type") String Type,
			@PathVariable("Name") String Name, HttpServletRequest request) {
		Object isValidUser = request.getSession().getAttribute("isAuthenticated");

		System.out.println("isValidUser:" + isValidUser);
		if (isValidUser != null) {
			if ((boolean) isValidUser) {
				System.out.println("is valid user and searching the product");
				return repository.findByName(Category, Type, Name);
			}
		}
		return null;
	}
}
