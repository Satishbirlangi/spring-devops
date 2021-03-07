package com.myapp.spring.repository;

public interface AdminRepository {

	String findByAdminCredentials(String Username, String Password);

	String AdminUI();
}
