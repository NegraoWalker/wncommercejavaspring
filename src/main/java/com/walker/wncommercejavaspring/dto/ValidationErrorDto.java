package com.walker.wncommercejavaspring.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDto extends CustomErrorDto{
    private List<FieldMessageDto> errors = new ArrayList<>();


    public ValidationErrorDto(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public ValidationErrorDto(Instant timestamp, Integer status, String error, String path, List<FieldMessageDto> errors) {
        super(timestamp, status, error, path);
        this.errors = errors;
    }


    public List<FieldMessageDto> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessageDto(fieldName, message));
    }
}
