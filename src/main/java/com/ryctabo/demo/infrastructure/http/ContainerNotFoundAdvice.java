package com.ryctabo.demo.infrastructure.http;

import com.ryctabo.demo.domain.container.ContainerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContainerNotFoundAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ContainerNotFoundException.class)
    String containerNotFoundHandler(ContainerNotFoundException ex) {
        return ex.getMessage();
    }
}
