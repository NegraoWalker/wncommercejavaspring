package com.walker.wncommercejavaspring.controller.handler;

import com.walker.wncommercejavaspring.dto.CustomErrorDto;
import com.walker.wncommercejavaspring.dto.ValidationErrorDto;
import com.walker.wncommercejavaspring.service.exception.DatabaseIntegrityViolationException;
import com.walker.wncommercejavaspring.service.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(DatabaseIntegrityViolationException.class)
    public ResponseEntity<CustomErrorDto> databaseIntegrityViolationException(DatabaseIntegrityViolationException databaseIntegrityViolationException, HttpServletRequest httpServletRequest) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        CustomErrorDto customErrorDto = new CustomErrorDto(Instant.now(), httpStatus.value(), databaseIntegrityViolationException.getMessage(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customErrorDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDto> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException, HttpServletRequest httpServletRequest) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDto validationErrorDto = new ValidationErrorDto(Instant.now(), httpStatus.value(), "Dados inválidos!", httpServletRequest.getRequestURI());
        for (FieldError fieldError: methodArgumentNotValidException.getFieldErrors()) {
            validationErrorDto.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(httpStatus).body(validationErrorDto);
    }
}
