package com.demo.security.first_demo;

public record LoginRequest(
        String username,
        String pwd
) {
}
