package com.liufei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.liufei.dao.UsercheckMapper;
import com.liufei.pojo.User;
import com.liufei.pojo.Usercheck;
import com.liufei.service.UsercheckService;
@Service
@Scope("prototype")
public class UsercheckServiceImpl implements UsercheckService{
	@Autowired
	private UsercheckMapper dao;
	@Override
	public List<Usercheck> selectAll() {
		return dao.selectAll();
	}
	@Override
	public int insertSelective(Usercheck record) {
		return dao.insertSelective(record);
	}

	@Override
	public List<Usercheck> selectByPage(int page, int perpage) {
		return dao.selectByPage(page, perpage);
	}
	@Override
	public List<Usercheck> selectByNameAndPage(String name, int page, int perpage) {
		return dao.selectByNameAndPage(name, page, perpage);
	}
	@Override
	public List<Usercheck> selectByName(String name) {
		return dao.selectByName(name);
	}
	@Override
	public List<Usercheck> selectByNamesAndPage(String name, int page, int perpage) {
		return dao.selectByNamesAndPage(name, page, perpage);
	}
	@Override
	public List<Usercheck> selectByNames(String name) {
		return dao.selectByNames(name);
	}
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dao.deleteByPrimaryKey(id);
	}

}
