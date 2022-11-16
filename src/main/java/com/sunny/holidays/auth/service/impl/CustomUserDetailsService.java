package com.sunny.holidays.auth.service.impl;

import com.sunny.holidays.auth.entity.User;
import com.sunny.holidays.auth.repository.UserRepository;
import com.sunny.holidays.auth.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if(user !=null)
        {
            userDetails = new CustomUserDetails();
            userDetails.setUser(user);
        }
        else {
            throw new UsernameNotFoundException("user not exits with the name" + username);
        }


        return userDetails;
    }

}
