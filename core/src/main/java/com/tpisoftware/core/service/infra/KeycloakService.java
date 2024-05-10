package com.tpisoftware.core.service.infra;

import com.tpisoftware.core.dto.data.AccessTokenData;
import com.tpisoftware.core.dto.request.GetAccessTokenRequest;
import java.util.Optional;

public interface KeycloakService {
    Optional<AccessTokenData> getAccessToken(GetAccessTokenRequest getAccessTokenRequest);
}
