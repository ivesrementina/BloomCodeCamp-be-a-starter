package com.hcc.controllers;

import com.hcc.DTOs.AuthCredentialRequest;
import com.hcc.entities.User;
import com.hcc.services.UserDetailServiceImpl;
import com.hcc.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailServiceImpl userDetailService;

    @Autowired
    JWTUtils jwtUtils;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody AuthCredentialRequest loginRequest) {
        // Perform authentication and generate a token
        try {
            Authentication authentication = authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            User user = (User)authentication.getPrincipal();
//            user.setPassword(null);

            String token = jwtUtils.generateToken(user);
            // Return the token in the response
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION,token).body(user.getUsername());
        } catch (BadCredentialsException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        // Logic to validate the token
        try {
            UserDetails userDetails = userDetailService.loadUserByUsername(jwtUtils.getUsernameFromToken(token));
            if (jwtUtils.validateToken(token, userDetails)) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
