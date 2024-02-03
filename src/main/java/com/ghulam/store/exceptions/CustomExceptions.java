package com.ghulam.store.exceptions;

import com.ghulam.store.utils.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptions {

    @ExceptionHandler(value = CustomerNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Result customerNotFound(CustomerNotFoundException ex) {
        return new Result(false, HttpStatus.NOT_FOUND, ex.getMessage());
    }


    // todo
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Result any_exceptions(RuntimeException ex) {
        System.err.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        System.err.println("I DON'T KNOW WHAT EXCEPTION HAS OCCURRED ------------------------------------------.");
        System.err.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
        ex.printStackTrace();

        return new Result(false, HttpStatus.NOT_FOUND, ex.getMessage());
    }

}
