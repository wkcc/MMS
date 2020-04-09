package com.demo.mapper;

import com.demo.my.mapper.MyMapper;
import com.demo.pojo.User;

import java.util.List;


public interface UserMapper extends MyMapper<User> {
    List<User> getUser();
    User getUserById(String userId);
    void addUser(String userId, String userName, String userPassWord);
}
