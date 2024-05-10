package com.tpisoftware.api.aop;

import com.tpisoftware.core.common.exception.ConflictException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AOPHandleExceptionQuestionTwo {
    @AfterThrowing(pointcut = "execution(* com.tpisoftware.api.controller.*.*(..))", throwing = "ex")
    public void handleException(Exception ex) {
        // Handle the exception here
        log.error("exception occurred: {}", ex.getMessage());
        // You can log, send notifications, etc.
        throw new ConflictException(ex.getMessage());
    }
}
