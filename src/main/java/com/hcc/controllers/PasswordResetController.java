package com.hcc.controllers;

import java.util.UUID;

import com.hcc.DTOs.PasswordReset;
import com.hcc.entities.PasswordResetToken;
import com.hcc.services.TokenService;
import com.hcc.services.EmailService;
import com.hcc.entities.User;
import com.hcc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/account")
public class PasswordResetController {
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private EmailService emailService;

    // Constructor with autowired dependencies

    @PostMapping("/reset-password")
    public ResponseEntity<String> requestPasswordReset(@RequestBody PasswordReset passwordReset) {
        String email = passwordReset.getEmail();

        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        PasswordResetToken token = new PasswordResetToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        token.setExpiryDate(LocalDateTime.now().plusHours(24));

        tokenService.saveToken(token);

        String resetLink = "http://localhost:3000/new-password/" + token.getToken();
        String emailContent = "Click the following link to reset your password: " + resetLink;
        emailService.sendForgotPasswordEmail(email, resetLink);

        return ResponseEntity.ok("Password reset email sent");
    }
}
