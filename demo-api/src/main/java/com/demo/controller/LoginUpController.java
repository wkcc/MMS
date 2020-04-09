package com.demo.controller;

import com.demo.mapper.UserMapper;
import com.demo.pojo.User;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginUpController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/getUser")
    public Object getUser(){
        User user = (User) userService.getUser();
        return user.toString();
    }

    @GetMapping("/addUser")
    public void addUser(String userId, String userName, String userPassWord){
        userService.addUser("wang","王","123");
    }
}
