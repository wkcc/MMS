package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser(){
        List<User> users = (List<User>) userMapper.getUser();
        return users;
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateUserById(user);
    }

    @Override
    public User login(String idOrName, String passWord) {
        return userMapper.login(idOrName, passWord);
    }

    @Override
    public void register(User user) {
        userMapper.register(user);
    }
}
