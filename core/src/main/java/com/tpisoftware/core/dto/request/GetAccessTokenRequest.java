package com.tpisoftware.core.dto.request;

import jakarta.validation.constraints.NotBlank;

public record GetAccessTokenRequest(@NotBlank String username, @NotBlank String password) {}
