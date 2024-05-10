package com.tpisoftware.core.service;

import com.tpisoftware.core.dto.data.AccessTokenData;
import com.tpisoftware.core.dto.request.GetAccessTokenRequest;
import com.tpisoftware.core.service.infra.KeycloakService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthenticationService {
    private final KeycloakService keycloakService;

    public Optional<AccessTokenData> getAccessToken(GetAccessTokenRequest getAccessTokenRequest) {
        return keycloakService.getAccessToken(getAccessTokenRequest);
    }
}
