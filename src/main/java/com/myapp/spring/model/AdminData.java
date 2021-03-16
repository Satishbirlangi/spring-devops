package com.myapp.spring.model;

public class AdminData {
	String adminUsername;
	private String adminPassword;

	public void setAdminUsername(String username) {
		adminUsername = username;
	}

	public void setAdminPassword(String password) {
		adminPassword = password;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	@Override
	public String toString() {
		return "AdminData [username=" + adminUsername + ", password=" + adminPassword + "]";
	}
}
