package com.mobisi.backend.Api.Controllers.ApiResponses;

public class ApiResponse<T> {
    public T data;
    public int status;
    public String msg;

    public ApiResponse(int status, String msg, T data) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }
}