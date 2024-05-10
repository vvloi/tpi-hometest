package com.tpisoftware.core.dto.data;

public record AccessTokenData(
        String token,
        long expiresIn,
        long refreshExpiresIn,
        String refreshToken,
        String tokenType,
        String idToken,
        String scope) {}
