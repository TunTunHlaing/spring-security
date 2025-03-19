package com.demo.security.first_demo.api;

import com.demo.security.first_demo.LoginRequest;
import com.demo.security.first_demo.LoginResponse;
import com.demo.security.first_demo.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/login-usr")
    public LoginResponse login (@RequestBody LoginRequest loginRequest) {
        var token = jwtUtils.generateToken(loginRequest.username());
        return new LoginResponse(token, null);
    }
}
