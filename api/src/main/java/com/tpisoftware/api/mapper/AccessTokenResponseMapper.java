package com.tpisoftware.api.mapper;

import com.tpisoftware.core.dto.data.AccessTokenData;
import com.tpisoftware.core.dto.response.AccessToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccessTokenResponseMapper {
    AccessToken convertFromData(AccessTokenData accessTokenData);
}
