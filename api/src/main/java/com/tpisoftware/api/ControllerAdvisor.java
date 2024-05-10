package com.tpisoftware.api;

import com.tpisoftware.core.common.exception.ApplicationException;
import com.tpisoftware.core.common.response.Response;
import com.tpisoftware.core.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Response<Void>> handleAppException(
            ApplicationException applicationException, WebRequest request) {
        log.error(
                "Application exception [code {}, message {}]",
                applicationException.getCode(),
                applicationException.getMessage());
        return ResponseEntity.status(applicationException.getHttpStatus())
                .body((Response.error(applicationException.getCode(), applicationException.getMessage())));
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request) {
        List<Map<String, String>> fieldsErrors = fieldsErrors(ex);
        log.error("ARGUMENT_NOT_VALID: {}", fieldsErrors);
        return new ResponseEntity<>(
                Response.error(ErrorCode.ARGUMENT_NOT_VALID, fieldsErrors(ex)),
                HttpStatus.BAD_REQUEST);
    }

    private List<Map<String, String>> fieldsErrors(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream()
                .map(
                        fieldError -> {
                            Map<String, String> map = new HashMap<>();
                            map.put("field", fieldError.getField());
                            map.put("message", fieldError.getDefaultMessage());
                            return map;
                        })
                .collect(Collectors.toList());
    }
}
