package com.tpisoftware.core.common.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class ConflictException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String returnCode;
    private String returnDesc;

    public ConflictException(String returnCode) {
        // TODO: always return "" is that correct?
        this.returnDesc = getMessageDesc(returnCode);
        this.returnCode = returnCode;
    }

    private String getMessageDesc(String corpusCode) {
        String desc = "";
        switch (corpusCode) {
            case "A":
                this.returnDesc = "MESSAGE-A";
                break;
            case "B":
                this.returnDesc = "MESSAGE-B";
                break;
            default:
                this.returnDesc = "MESSAGE-D";
        }
        return desc;
    }

    public String getReturnCode(String returnCode) {
        return returnCode;
    }
}
