package com.hcc.services;

import com.hcc.entities.PasswordResetToken;
import com.hcc.repositories.PasswordResetTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    private PasswordResetTokenRepository passwordResetTokenRepository;

    public TokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    @Override
    public PasswordResetToken saveToken(PasswordResetToken token) {
        return passwordResetTokenRepository.save(token);
    }

    @Override
    public PasswordResetToken findByToken(String token) {
        return passwordResetTokenRepository.findByToken(token);
    }
}





