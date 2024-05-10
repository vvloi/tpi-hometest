package com.tpisoftware.api.controller;

import com.tpisoftware.api.dto.response.ExecutionRecordResponse;
import com.tpisoftware.api.mapper.ExecutionRecordResponseMapper;
import com.tpisoftware.core.common.exception.ConflictException;
import com.tpisoftware.core.common.response.Response;
import com.tpisoftware.core.dto.data.ExecutionRecordData;
import com.tpisoftware.core.service.HomeTestQuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/test-controllers")
@RequiredArgsConstructor
@Slf4j
public class HomeTestController {
    private final ExecutionRecordResponseMapper executionRecordResponseMapper;
    private final HomeTestQuestionService homeTestQuestionService;

    @GetMapping("/question-1")
    public ResponseEntity<Response<List<ExecutionRecordResponse>>> getExecutionRecords() {
        log.info("QUESTION 1: Start get all execution records from DB.");
        return Optional.ofNullable(homeTestQuestionService.getExecutionData())
                .map(executionRecordResponseMapper::fromData)
                .map(Response::success)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ConflictException("A"));
    }

    @GetMapping("/question-2")
    public ResponseEntity<Response<Void>> thrExceptionQuestion2() throws Exception {
        log.info("QUESTION 2: handle exception combine AOP pointcut controller and controller advice.");
        throw new Exception("B");
    }

    @GetMapping("/question-3")
    public ResponseEntity<Response<Void>> getZoo() throws Exception {
        log.info("QUESTION 3: print zoo animal to console");
        return ResponseEntity.ok(Response.success(homeTestQuestionService.printZoo()));
    }

    @GetMapping("/question-4")
    public ResponseEntity<Response<List<String>>> getUnique() throws Exception {
        log.info("QUESTION 4: return list 2 item id of calculation as the same id");
        return ResponseEntity.ok(Response.success(homeTestQuestionService.getUniqueCalculation()));
    }
}
