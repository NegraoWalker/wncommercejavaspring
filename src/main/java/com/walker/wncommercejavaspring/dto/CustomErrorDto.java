package com.walker.wncommercejavaspring.dto;

import java.time.Instant;

public class CustomErrorDto {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    public CustomErrorDto() {
    }

    public CustomErrorDto(Instant timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}


// Formato de erro anteriormente:
//    {
//        "timestamp": "2024-10-19T20:44:27.118+00:00",
//        "status": 500,
//        "error": "Internal Server Error",
//        "path": "/products/26"
//    }