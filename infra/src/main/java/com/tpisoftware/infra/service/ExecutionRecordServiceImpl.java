package com.tpisoftware.infra.service;

import com.tpisoftware.core.dto.data.ExecutionRecordData;
import com.tpisoftware.core.service.infra.ExecutionRecordService;
import com.tpisoftware.infra.mapper.ExecutionRecordMapper;
import com.tpisoftware.infra.question4.Calculation;
import com.tpisoftware.infra.repository.ExecutionRecordDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExecutionRecordServiceImpl implements ExecutionRecordService {
    private final ExecutionRecordDAO executionRecordDAO;
    private final ExecutionRecordMapper executionRecordMapper;

    @Override
    public List<ExecutionRecordData> getExecutionRecord() {
        return executionRecordMapper.fromEntity(executionRecordDAO.findAll());
    }

    @Override
    @SneakyThrows
    public List<String> getUniqueCalculation() {
        List<String> result = new ArrayList<>();
        try (ExecutorService executor = Executors.newFixedThreadPool(1); ) {
            Callable<String> instance1 = () -> Calculation.getInstance().toString();
            Callable<String> instance2 = () -> Calculation.getInstance().toString();
            List<Future<String>> poolResult = executor.invokeAll(List.of(instance1, instance2));
            for (Future<String> stringFuture : poolResult) {
                result.add(stringFuture.get());
            }
        }

        return result;
    }
}
