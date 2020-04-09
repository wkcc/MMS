package com.demo.mapper;

import com.demo.my.mapper.MyMapper;
import com.demo.pojo.User;


public interface UserMapper extends MyMapper<User> {
    User getUser();
    void addUser(String userId, String userName, String userPassWord);
}
