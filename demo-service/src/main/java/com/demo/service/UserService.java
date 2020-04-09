package com.demo.service;

import com.demo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;

public interface UserService {
    Object getUser();
    void addUser(String userId, String userName, String userPassWord);
}
