package com.igp.imagegenerationservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Achintha Kalunayaka
 * @since 4/8/2025
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errorsMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> errorsMap.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errorsMap);
    }

    @ExceptionHandler(PackNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePackNotFoundException(PackNotFoundException exception) {
        Map<String, String> errorsMap = new HashMap<>();
        logger.warn("Pack not found {}", exception.getMessage());
        errorsMap.put("Message ", "Pack Not Found with Given pack Id");
        return ResponseEntity.badRequest().body(errorsMap);
    }
}
