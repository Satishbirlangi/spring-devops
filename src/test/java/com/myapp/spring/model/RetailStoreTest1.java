/*package com.myapp.spring.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.springframework.http.HttpStatus;

class RetailStoreTest1 extends RetailStore {
	public void test1() {

		String Category1 = "Cooking_Essentials";

		String Type1 = "Rice";

		String Name1 = "BasmatiRice";

		assertEquals("true", validate(Category1, Type1, Name1));

	}
}

*/

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
	private static File DATA_JSON = Paths.get("src", "test", "resources", "retaildata.json").toFile();

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

		((RetailStore) r).setCategory("Cooking_Essentials");
		rt.setId(1111);
		rt.setBrand("Fortune");
		rt.setPrice(265);
		rt.setName("BasmatiRice");
		rt.setExpiry_Date("2022-09-13T07:00:00.000+00:00");
		rt.setType("Rice");
		rt.setQuantity("5kg");
		rt.setStock(90);

		// prepared mock service method

		doReturn(r).when(service).findByCategory(((RetailStore) r).getCategory());

		// perform get request

		mockMvc.perform(MockMvcRequestBuilders.get("search/retail_store/{Category}", "Cooking_Essentials"))
				// .andExpect(status().isOk())//.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andDo(print())
				// validate response body

				// {"id":1,"airlines":"Airindia","distance":789}

				.andExpect(jsonPath("$[0].category", is("Cooking_Essentials"))).andExpect(jsonPath("$.id", is(1111)))
				.andExpect(jsonPath("$.brand", is("Fortune"))).andExpect(jsonPath("$.price", is(265)))
				.andExpect(jsonPath("$.name", is("BasmatiRice"))).andExpect(jsonPath("$.type", is("Rice")))
				.andExpect(jsonPath("$.stock", is(90))).andExpect(jsonPath("$.quantity", is("5kg")))
				.andExpect(jsonPath("$.expiry_Date", is("2022-09-13T07:00:00.000+00:00")));

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