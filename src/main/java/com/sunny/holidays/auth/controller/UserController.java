package com.sunny.holidays.auth.controller;

import com.sunny.holidays.auth.entity.User;
import com.sunny.holidays.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String addUser(@RequestBody User user)
    {
        String pwd = user.getPassword();
        String encrptedPwd = passwordEncoder.encode(pwd);
        user.setPassword(encrptedPwd);
        userRepository.save(user);
        return "user Added Successfully";
    }
}
