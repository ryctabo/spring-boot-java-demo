package com.ryctabo.demo.infrastructure.http;

import com.ryctabo.demo.domain.container.InvalidContainerNameException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = ContainerController.class)
public class ContainerBadRequestAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ProblemDetail> validationHandler(MethodArgumentNotValidException ex) {
        var errors = ex.getBindingResult().getFieldErrors();
        var detail = "Request validation failed";
        var problem = badRequestProblem(detail);
        if (!errors.isEmpty()) {
            var formatted = errors.stream()
                    .map(ContainerBadRequestAdvice::formatFieldError)
                    .toList();
            problem.setProperty("errors", formatted);
        }
        return ResponseEntity.of(problem).build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ProblemDetail> constraintViolationHandler(ConstraintViolationException ex) {
        var detail = "Request validation failed";
        var violations = ex.getConstraintViolations().stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .toList();
        var problem = badRequestProblem(detail);
        if (!violations.isEmpty()) {
            problem.setProperty("errors", violations);
        }
        return ResponseEntity.of(problem).build();
    }

    @ExceptionHandler({IllegalArgumentException.class, InvalidContainerNameException.class})
    ResponseEntity<ProblemDetail> invalidArgumentHandler(RuntimeException ex) {
        return ResponseEntity.of(badRequestProblem(ex.getMessage())).build();
    }

    private static String formatFieldError(FieldError error) {
        var defaultMessage = error.getDefaultMessage();
        if (defaultMessage == null || defaultMessage.isBlank()) {
            return error.getField() + ": invalid value";
        }
        return error.getField() + ": " + defaultMessage;
    }

    private static ProblemDetail badRequestProblem(String detail) {
        var problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, detail);
        problem.setTitle("Bad Request");
        problem.setProperty("code", "BAD_REQUEST");
        return problem;
    }
}
