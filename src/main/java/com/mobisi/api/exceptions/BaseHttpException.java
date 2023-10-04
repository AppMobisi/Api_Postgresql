package com.mobisi.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseHttpException extends Exception {
    private Integer statusCode;
    private String message;
}
