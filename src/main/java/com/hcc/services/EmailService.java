package com.hcc.services;

public interface EmailService {
    void sendEmail(String to, String subject, String content);
    void sendForgotPasswordEmail(String to, String resetLink);
}