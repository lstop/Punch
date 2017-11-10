package com.liufei.service;

import java.util.List;

import com.liufei.pojo.User;

public interface UsersService {
	List<User> selectAll();
	
	List<User> selectByUnameAndUpassword(User user);
	
}
