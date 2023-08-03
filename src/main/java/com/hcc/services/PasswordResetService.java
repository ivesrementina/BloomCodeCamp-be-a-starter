package com.hcc.services;

import com.hcc.entities.PasswordResetToken;
import com.hcc.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;

    // This method should be called when the user requests a password reset
    public void createPasswordResetTokenForEmail(String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            String token = UUID.randomUUID().toString(); // Token generation logic can vary based on your needs
            LocalDateTime expiryDate = LocalDateTime.now().plusHours(1); // The token expires in 1 hour. Adjust based on your needs
            PasswordResetToken passwordResetToken = new PasswordResetToken(token, user, expiryDate);
            tokenService.saveToken(passwordResetToken);

            // Add logic here to send email to user with token
        }
    }

    // This method should be called when the user submits a new password
    public void resetPassword(String token, String newPassword) {
        PasswordResetToken resetToken = tokenService.findByToken(token);
        if (resetToken != null) {
            User user = resetToken.getUser();
            user.setPassword(newPassword);
            userService.registerUser(user);
        } else {
            throw new RuntimeException("Invalid token");
        }
    }
}
