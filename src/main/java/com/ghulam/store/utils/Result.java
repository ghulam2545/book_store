package com.ghulam.store.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class Result {

    private boolean flag;
    private HttpStatus status;
    private String message;
    private Object data;

    public Result(boolean flag, HttpStatus status, String message) {
        this.flag = flag;
        this.status = status;
        this.message = message;
    }
}
