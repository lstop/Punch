package com.liufei.dao;

import java.util.List;

import com.liufei.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectByUnameAndUpassword(User user);
    
    List<User> selectAll();
}