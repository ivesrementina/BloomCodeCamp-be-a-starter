package com.hcc.services;

import com.hcc.entities.User;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public interface UserService {

    User findByEmail(String email);
    User registerUser(User user) ;
}