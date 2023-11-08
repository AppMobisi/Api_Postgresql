package com.mobisi.api.responses;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ErrorResponse implements ApiResponse {
    public Integer statusCode;
    public String message;
    public List<String> errors;

    public ErrorResponse(Integer statusCode, String message) {
        this.message = message;
        this.statusCode = statusCode;
    }
}