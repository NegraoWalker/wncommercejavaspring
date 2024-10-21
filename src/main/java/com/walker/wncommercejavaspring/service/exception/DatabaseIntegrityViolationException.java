package com.walker.wncommercejavaspring.service.exception;

public class DatabaseIntegrityViolationException extends RuntimeException{
    public DatabaseIntegrityViolationException(String message) {
        super(message);
    }
}
