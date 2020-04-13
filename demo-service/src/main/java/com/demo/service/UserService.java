package com.demo.service;

import com.demo.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserService {
    List<User> getUser();
    void updateUserById(User user);
    User login(String idOrName, String passWord);
    void register(User user);
}
