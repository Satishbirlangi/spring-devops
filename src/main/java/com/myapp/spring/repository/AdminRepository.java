package com.myapp.spring.repository;

import com.myapp.spring.model.UserData;

public interface AdminRepository {

	UserData saveDetails(UserData admindata);

	UserData findByUnameandPwd(String Username, String Password);
}
