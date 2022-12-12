package com.losgif.senbeiapi.handles;

import com.losgif.senbeiapi.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(value = AccessDeniedException.class)
    public ApiResponse handler(AccessDeniedException e) {
        log.info("security权限不足：----------------{}", e.getMessage());
        return ApiResponse.fail("权限不足");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ApiResponse handler(IllegalArgumentException e) {
        log.error("Assert异常：----------------{}", e.getMessage());
        return ApiResponse.fail(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ApiResponse handler(RuntimeException e) {
        log.error("运行时异常：----------------{}", e.getMessage());
        return ApiResponse.fail(e.getMessage());
    }
}
