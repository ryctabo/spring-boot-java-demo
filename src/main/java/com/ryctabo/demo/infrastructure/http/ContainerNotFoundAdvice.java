package com.ryctabo.demo.infrastructure.http;

import com.ryctabo.demo.domain.container.ContainerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ContainerNotFoundAdvice {

    @ExceptionHandler(ContainerNotFoundException.class)
    ResponseEntity<ProblemDetail> containerNotFoundHandler(ContainerNotFoundException ex) {
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problem.setTitle("Container Not Found");
        problem.setProperty("code", "CONTAINER_NOT_FOUND");
        return ResponseEntity.of(problem).build();
    }
}
