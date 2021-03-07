package com.myapp.spring.model;

public class AdminData {

	private String Username;

	private String Password;

	public String getUsername() {
		return Username;
	}

	/**
	 * @param username
	 * @param password
	 */
	public AdminData(String Username, String Password) {
		this.Username = Username;
		this.Password = Password;
	}

	public void setUsername(String Username) {
		this.Username = Username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

}
