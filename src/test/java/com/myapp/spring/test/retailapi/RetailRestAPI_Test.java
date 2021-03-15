package com.myapp.spring.test.retailapi;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.spring.model.RetailStore;
import com.myapp.spring.repository.RetailStoreRepository;

@SpringBootTest

//spring context
//environment
//loading the beans
//start the embeded tomcat server
@AutoConfigureMockMvc
public class RetailRestAPI_Test {

	@MockBean
	private RetailStoreRepository service;

	@Autowired
	private MockMvc mockMvc;
	private static File DATA_JSON = Paths.get("src", "main", "resources", "retaildata.json").toFile();

	// List<RetailStore> products[] = null;
	RetailStore products[] = null;

	@BeforeEach
	void setup() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("running");
		// products = (List<RetailStore>[]) new ObjectMapper().readValue(DATA_JSON,
		// RetailStore[].class);
		products = new ObjectMapper().readValue(DATA_JSON, RetailStore[].class);

	}

	@Test
	@DisplayName("RetailRestAPI Testing with Category")
	public void TestingCategory() throws Exception {

		// Prepared mock flight
		RetailStore rt = new RetailStore();
		List<RetailStore> r = new ArrayList<RetailStore>();

		rt.setCategory("Cooking_Essentials");
		rt.setId(1111);
		rt.setBrand("Fortune");
		rt.setPrice(265);
		rt.setName("BasmatiRice");
		// rt.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		rt.setType("Rice");
		rt.setQuantity("5kg");
		rt.setStock(90);
		r.add(rt);
		// r.add("category","CookingEssentials");

		// prepared mock service method

		doReturn(r).when(service).findByCategory(rt.getCategory());

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("/retail_store/search/{Category}", "Cooking_Essentials"))
				// .andExpect(status().isOk())//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$[0].category", is("Cooking_Essentials"))).andExpect(jsonPath("$[0].id", is(1111)))
				.andExpect(jsonPath("$[0].brand", is("Fortune"))).andExpect(jsonPath("$[0].price", is(265)))
				.andExpect(jsonPath("$[0].name", is("BasmatiRice"))).andExpect(jsonPath("$[0].type", is("Rice")))
				.andExpect(jsonPath("$[0].stock", is(90))).andExpect(jsonPath("$[0].quantity", is("5kg")));
		// .andExpect(jsonPath("$[0].expiry_Date",
		// is("2022-09-13T07:00:00.000+00:00")));

		/*
		 * is(" {\r\n" + "    \"id\": 1111,\r\n" +
		 * "    \"category\": \"Cooking_Essentials\",\r\n" + "    \"price\": 265,\r\n" +
		 * "    \"brand\": \"Fortune\",\r\n" +
		 * "    \"expiry_Date\": \"2022-09-13T07:00:00.000+00:00\",\r\n" +
		 * "    \"quantity\": \"5kg\",\r\n" + "    \"name\": \"BasmatiRice\",\r\n" +
		 * "    \"type\": \"Rice\",\r\n" + " \"stock\":90\r\n" + "}")));
		 */
	}

}
