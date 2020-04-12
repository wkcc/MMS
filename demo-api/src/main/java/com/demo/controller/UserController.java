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
    @Autowired
    private User user;
    @GetMapping("/get")
    public Object getUser(){
        List<User> users = userService.getUser();
        return users;
    }

    @PostMapping("/update")
    public HttpStatus updateUserById(@RequestBody UserBo userBo){
        user.setUserId(userBo.getUserId());
        user.setUserName(userBo.getUserName());
        user.setPassWord(userBo.getPassWord());
        userService.updateUserById(user);
        return HttpStatus.OK;
    }

    @PostMapping("/login")
    public User login(@RequestBody UserBo userBo){
        user = userService.login(userBo.getIdOrName(), userBo.getPassWord());
        return user;
    }

    @PostMapping("/sign_up")
    public HttpStatus signUp(@RequestBody UserBo userBo){
        user.setUserId(userBo.getUserId());
        user.setUserName(userBo.getUserName());
        user.setPassWord(userBo.getPassWord());
        userService.signUp(user);
        return HttpStatus.OK;
    }

}
