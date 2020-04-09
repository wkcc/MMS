package com.demo.controller;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getUser")
    public Object getUser(){
        List<User> users = userService.getUser();
        return users.toString();
    }

    @GetMapping("/getUserById")
    public Object getUserById(String userId){
        User user = (User) userService.getUserById(userId);
        return user.toString();
    }

    @GetMapping("/addUser")
    public void addUser(String userId, String userName, String userPassWord){
        userService.addUser(userId, userName, userPassWord);
    }
}
