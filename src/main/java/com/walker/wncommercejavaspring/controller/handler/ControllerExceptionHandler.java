package com.walker.wncommercejavaspring.controller.handler;

import com.walker.wncommercejavaspring.dto.CustomErrorDto;
import com.walker.wncommercejavaspring.service.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorDto> resourceNotFoundException(ResourceNotFoundException resourceNotFoundException, HttpServletRequest httpServletRequest) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomErrorDto customErrorDto = new CustomErrorDto(Instant.now(), httpStatus.value(), resourceNotFoundException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customErrorDto);
    }
}
