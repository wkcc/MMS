package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.demo.bo.UserBo;
import com.demo.common.CookieUtils;
import com.demo.pojo.User;
import com.demo.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:8083")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private User user;
    final static Logger logger = LoggerFactory.getLogger(UserController.class);

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
    @Transactional(propagation = Propagation.SUPPORTS)
    @PostMapping("login")
    public Object login(@RequestBody UserBo userBo, HttpServletRequest request, HttpServletResponse response){
        logger.info("login:" + userBo.getIdOrName());
        String idOrName = userBo.getIdOrName();
        String passWord = userBo.getPassWord();
        if(idOrName == null)
                return HttpStatus.UNAUTHORIZED;
        else if(passWord == null)
                return HttpStatus.UNAUTHORIZED;
        user = userService.login(idOrName, passWord);
        CookieUtils.setCookie(request, response, "user", JSON.toJSONString(user), true);
        return user;
    }

    @PostMapping("register")
    public HttpStatus register(@RequestBody UserBo userBo, HttpServletRequest request, HttpServletResponse response){
        user.setUserId(userBo.getUserId());
        user.setUserName(userBo.getUserName());
        user.setPassWord(userBo.getPassWord());
        userService.register(user);
        CookieUtils.setCookie(request, response, "user", JSON.toJSONString(user), true);
        return HttpStatus.OK;
    }

}
