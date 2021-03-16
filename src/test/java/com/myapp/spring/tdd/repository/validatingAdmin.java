package com.myapp.spring.tdd.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.myapp.spring.model.AdminData;

public class validatingAdmin {
	@MockBean
	private AdminData ad;

	@Test
	@DisplayName("Validating admin")
	public void ValidatingAdmin() {
		AdminData ad = new AdminData();
		ad.setAdminUsername("admin");
		ad.setAdminPassword("admin");
		AdminData ad1 = new AdminData();
		ad1.setAdminUsername("admin");
		ad1.setAdminPassword("admin");

		assertNotNull(ad);
		assertSame("admin", ad.getAdminPassword());
		assertSame("admin", ad.getAdminUsername());
		assertSame("admin", ad1.getAdminPassword());
		assertSame("admin", ad1.getAdminUsername());

	}

}
