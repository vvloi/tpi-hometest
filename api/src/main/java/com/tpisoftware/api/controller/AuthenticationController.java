package com.tpisoftware.api.controller;

import com.tpisoftware.api.mapper.AccessTokenResponseMapper;
import com.tpisoftware.core.common.response.Response;
import com.tpisoftware.core.dto.request.GetAccessTokenRequest;
import com.tpisoftware.core.dto.response.AccessToken;
import com.tpisoftware.core.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AccessTokenResponseMapper accessTokenResponseMapper;

    @PostMapping("/login")
    @SneakyThrows
    public ResponseEntity<Response<AccessToken>> getAccessToken(
            @RequestBody @Valid GetAccessTokenRequest getAccessTokenRequest) {
        return authenticationService
                .getAccessToken(getAccessTokenRequest)
                .map(accessTokenResponseMapper::convertFromData)
                .map(Response::success)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

    @PreAuthorize("hasRole('default-roles-preschool_be_sit')")
    @PostMapping("/logout")
    public ResponseEntity<Response<AccessToken>> getAccessToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        System.out.printf("ádasdasdsad " + jwtAuthenticationToken.getTokenAttributes());
        return null;
    }
}
