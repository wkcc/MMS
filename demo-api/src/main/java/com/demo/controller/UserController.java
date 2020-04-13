package com.demo.controller;

import com.demo.bo.UserBo;
import com.demo.pojo.User;
import com.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:8083")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private User user;
    @GetMapping("user")
    public Object getUser(){
        List<User> users = userService.getUser();
        return users;
    }

    @PostMapping("user/id")
    public HttpStatus updateUserById(@RequestBody UserBo userBo){
        user.setUserId(userBo.getUserId());
        user.setUserName(userBo.getUserName());
        user.setPassWord(userBo.getPassWord());
        userService.updateUserById(user);
        return HttpStatus.OK;
    }

    @PostMapping("login")
    public Object login(@RequestBody UserBo userBo){
        String idOrName = userBo.getIdOrName();
        String passWord = userBo.getPassWord();
        if(idOrName == null)
                return HttpStatus.UNAUTHORIZED;
        else if(passWord == null)
                return HttpStatus.UNAUTHORIZED;
        user = userService.login(idOrName, passWord);
        return user;
    }

    @PostMapping("register")
    public HttpStatus register(@RequestBody UserBo userBo){
        user.setUserId(userBo.getUserId());
        user.setUserName(userBo.getUserName());
        user.setPassWord(userBo.getPassWord());
        userService.register(user);
        return HttpStatus.OK;
    }

}
