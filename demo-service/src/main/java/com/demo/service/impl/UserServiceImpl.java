package com.demo.service.impl;

import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserService userService;

    @Override
    public boolean queryUserNameIsExits(String userName) {

        return false;
    }
}
