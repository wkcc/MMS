package com.demo.mapper;

import com.demo.my.mapper.MyMapper;
import com.demo.pojo.User;

import java.util.List;


public interface UserMapper extends MyMapper<User> {
    List<User> getUser();
    void updateUserById(User user);
    User login(String idOrName, String passWord);
    void register(User user);
}
