package com.tpisoftware.core.service;

import com.tpisoftware.core.dto.data.ExecutionRecordData;
import com.tpisoftware.core.dto.question3.Zoo;
import com.tpisoftware.core.service.infra.ExecutionRecordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HomeTestQuestionService {
    private final ExecutionRecordService executionRecordService;
    private final Zoo zoo;

    public List<ExecutionRecordData> getExecutionData() {
        return executionRecordService.getExecutionRecord();
    }

    public Void printZoo() {
        zoo.process();
        return null;
    }

    public List<String> getUniqueCalculation() {
        return executionRecordService.getUniqueCalculation();
    }
}
