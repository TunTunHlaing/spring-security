package com.demo.security.first_demo;

public record LoginResponse(
        String accessToken,
        String refreshToken
) {
}
