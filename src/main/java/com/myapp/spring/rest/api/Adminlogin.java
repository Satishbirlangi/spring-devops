package com.myapp.spring.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.repository.AdminRepository;

@RestController
@RequestMapping("/admincredentials")
public class Adminlogin {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private AdminRepository adminrepo;

	@GetMapping("/login/{Username}/{Password}")
	public String findByUsername(@PathVariable("Username") String Username, @PathVariable("Password") String Password) {

		try {
			String query = "select Username from registry where Username=?";
			Object[] inputs = new Object[] { Username };
			String username = jdbcTemplate.queryForObject(query, String.class, inputs);
			String query1 = "select Password from registry where Password=?";
			Object[] inputs1 = new Object[] { Password };
			String password = jdbcTemplate.queryForObject(query1, String.class, inputs1);

			if (Username == username) {
				if (password == Password) {
					// return Integer.toString(empName);
					return "<html><body>" + "<h1>Welcome To Abc Airline Service</h1><br> <h3>Mr. " + username
							+ " You can serach for our flight</h3>" + "</body></html>";
				} else {
					// return Integer.toString(productid);
					return "<html><body>" + "<h1>Sorry! Your Password is Wrong</h1><br> <h3>Please try again!</h3>"
							+ "</body></html>";
				}
			} else {
				// return Integer.toString(productid);
				return "<html><body>" + "<h1>Sorry! Your Username is Wrong </h1><br> <h3>Please try again!</h3>"
						+ "</body></html>";
			}
		} catch (Exception e) {
			return "<html><body>"
					+ "<h1>Sorry!</h1><br> <h3>This Username is not registered <br> Please register soon.</h3>"
					+ "</body></html>";
		}

	}

//	@PostMapping
//	public UserData saveDetails(@RequestBody UserData admindata) {
//		return repository.saveProduct(product);
//	}
}
