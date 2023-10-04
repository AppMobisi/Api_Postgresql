package com.mobisi.api.responses;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DefaultResponse<T> implements ApiResponse {
    public int statusCode;
    public T data;
}
