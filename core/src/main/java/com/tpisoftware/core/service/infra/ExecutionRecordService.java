package com.tpisoftware.core.service.infra;

import com.tpisoftware.core.dto.data.ExecutionRecordData;
import java.util.List;

public interface ExecutionRecordService {
    List<ExecutionRecordData> getExecutionRecord();

    List<String> getUniqueCalculation();
}
