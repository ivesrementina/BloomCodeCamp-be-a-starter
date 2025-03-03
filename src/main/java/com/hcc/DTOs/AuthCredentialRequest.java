package com.hcc.DTOs;

public class AuthCredentialRequest {
    private String username;
    private String password;

    public AuthCredentialRequest() {
    }
    public AuthCredentialRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public AuthCredentialRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthCredentialRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
