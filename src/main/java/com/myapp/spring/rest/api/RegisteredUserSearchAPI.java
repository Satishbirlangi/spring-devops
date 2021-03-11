package com.myapp.spring.rest.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.Orders;
import com.myapp.spring.model.RetailStore;
import com.myapp.spring.repository.RetailStoreRepository;

@RestController
@RequestMapping("retail_store")

public class RegisteredUserSearchAPI {
	@Autowired
	private RetailStoreRepository repository;

	@GetMapping("/reg_search")
	public List<RetailStore> findAll(HttpServletRequest request) {
		Object isValidUser = request.getSession().getAttribute("isAuthenticated");

		System.out.println("isValidUser:" + isValidUser);
		if (isValidUser != null) {
			if ((boolean) isValidUser) {
				System.out.println("is valid user and searching the product");
				return repository.findAll();
			}
		}
		return null;
	}

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

	@PostMapping("/{Category}/{Type}/{Name}/RegUseraddtocart")
	public Orders reguserplacedOrder(@PathVariable("Category") String Category, @PathVariable("Type") String Type,
			@PathVariable("Name") String Name, @RequestBody Orders Ord, HttpServletRequest request) {
		Object oun = Ord.getUsername();
		Object run = request.getSession().getAttribute("registeredusername");

		Object isValidUser = request.getSession().getAttribute("isAuthenticated");
		System.out.println("isValidUser:" + isValidUser);
		if (isValidUser != null && run.equals(oun) && Ord.getCount() != 0 && Ord.getCategory() == Category
				&& Ord.getType() == Type && Ord.getName() == Name) {
			if ((boolean) isValidUser) {
				System.out.println("is valid user and Adding the product");

				return repository.reguserplacedOrder(Category, Type, Name, Ord);
			}
		}
		return null;

	}

}
