package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User findByUser() {

        String greeting = "Assasdasdasd";
        byte[] decodedBytes = Base64.getDecoder().decode(greeting);
        String decodedString = new String(decodedBytes);
        return new User();
    }
}