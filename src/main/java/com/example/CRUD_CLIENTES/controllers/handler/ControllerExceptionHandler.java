package com.example.CRUD_CLIENTES.controllers.handler;

import com.example.CRUD_CLIENTES.DTO.CustomError;
import com.example.CRUD_CLIENTES.exceptions.DatabaseException;
import com.example.CRUD_CLIENTES.exceptions.ResourceNotFoundExeception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<CustomError> dataIntegrityViolationException(DatabaseException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        CustomError customError = new CustomError(Instant.now(), httpStatus.value(),
                                  e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customError);
    }

    @ExceptionHandler(ResourceNotFoundExeception.class)
    public ResponseEntity<CustomError> resourceNotFoundExeception(ResourceNotFoundExeception e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomError customError = new CustomError(Instant.now(), httpStatus.value(),
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customError);
    }
}
