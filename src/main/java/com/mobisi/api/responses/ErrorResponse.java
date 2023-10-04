package com.mobisi.api.responses;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse implements ApiResponse {
    public Integer statusCode;
    public String message;
}