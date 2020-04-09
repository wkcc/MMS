package com.demo.service;

import com.demo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserService {
    List<User> getUser();
    User getUserById(String userId);
    void addUser(String userId, String userName, String userPassWord);
}
