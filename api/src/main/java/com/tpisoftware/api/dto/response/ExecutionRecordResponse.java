package com.tpisoftware.api.dto.response;

import java.sql.Timestamp;

public record ExecutionRecordResponse(
        int serno,
        String serviceName,
        String msgid,
        String requestPayload,
        Timestamp requestTimestamp) {}
