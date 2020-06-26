package com.integration.controller.exception;

import com.integration.exception.NotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by Junior on 25/06/2020.
 */
@RestControllerAdvice
public class PersonExceptionHandler {

    @ExceptionHandler(NotExistException.class)
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void handleNotExist(){}

}
