package com.tpisoftware.core.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    ARGUMENT_NOT_VALID("ARGUMENT_NOT_VALID", "Some argument fields not valid");

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private final String code;
    private final String message;
}
