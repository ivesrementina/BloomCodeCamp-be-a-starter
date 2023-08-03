package com.hcc.services;

import com.hcc.entities.PasswordResetToken;

public interface TokenService {
    PasswordResetToken saveToken(PasswordResetToken token);
    PasswordResetToken findByToken(String token);
}