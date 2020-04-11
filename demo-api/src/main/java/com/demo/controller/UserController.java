package com.demo.controller;

import com.demo.bo.UserBo;
import com.demo.pojo.User;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin("http://127.0.0.1:8083")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/get")
    public Object getUser(){
        List<User> users = userService.getUser();
        return users;
    }

    @GetMapping("/getById")
    public Object getUserById(@RequestParam String userId){
        User user = (User) userService.getUserById(userId);
        return user.toString();
    }

    @PostMapping("/add")
    public HttpStatus addUser(@RequestBody UserBo userBo){
        userService.addUser(userBo.getUserId(), userBo.getUserName(), userBo.getUserPassWord());
        return HttpStatus.OK;
    }
}
