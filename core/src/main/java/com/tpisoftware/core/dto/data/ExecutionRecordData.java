package com.tpisoftware.core.dto.data;

import java.sql.Timestamp;

public record ExecutionRecordData(int serno, String serviceName, String msgid, String requestPayload, Timestamp requestTimestamp) {}
