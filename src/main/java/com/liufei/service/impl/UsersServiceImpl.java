package com.liufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.liufei.dao.UserMapper;
import com.liufei.pojo.User;
import com.liufei.service.UsersService;
@Service
@Scope("prototype")
public class UsersServiceImpl implements UsersService{
	@Autowired
	private UserMapper dao;
	@Override
	public List<User> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<User> selectByUnameAndUpassword(User user) {
		return dao.selectByUnameAndUpassword(user);
	}


	
	
	
}
