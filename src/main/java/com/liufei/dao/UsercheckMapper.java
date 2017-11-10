package com.liufei.dao;

import java.util.List;

import com.liufei.pojo.Usercheck;

public interface UsercheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usercheck record);

    int insertSelective(Usercheck record);

    Usercheck selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Usercheck record);

    int updateByPrimaryKey(Usercheck record);
    
    List<Usercheck> selectAll();
    
    List<Usercheck> selectByPage(int page,int perpage);
    
    List<Usercheck> selectByNameAndPage(String name,int page,int perpage);
    
    List<Usercheck> selectByNamesAndPage(String uname,int page,int perpage);
    
    List<Usercheck> selectByName(String name);
    
    List<Usercheck> selectByNames(String uname);
}