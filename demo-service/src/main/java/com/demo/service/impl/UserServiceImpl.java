package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUser(){
        List<User> users = (List<User>) userMapper.getUser();
        return users;
    }

    public void addUser(String userId, String userName, String userPassWord){
        userMapper.addUser(userId, userName, userPassWord);
    }

    public User getUserById(String userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
}
