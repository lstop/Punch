package com.liufei.service;

import java.util.List;

import com.liufei.pojo.Usercheck;

public interface UsercheckService {
	List<Usercheck> selectAll();
	
	int insertSelective(Usercheck record);
	
	List<Usercheck> selectByNameAndPage(String name,int page,int perpage);
	
	List<Usercheck> selectByNamesAndPage(String name,int page,int perpage);
	
	List<Usercheck> selectByPage(int page,int perpage);
	
	List<Usercheck> selectByName(String name);
	
	List<Usercheck> selectByNames(String name);
	
	int deleteByPrimaryKey(Integer id);
}
