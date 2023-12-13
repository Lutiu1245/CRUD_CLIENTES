package com.example.CRUD_CLIENTES.controllers.handler;

import com.example.CRUD_CLIENTES.DTO.CustomError;
import com.example.CRUD_CLIENTES.DTO.FieldMessageDTO;
import com.example.CRUD_CLIENTES.DTO.ValidationErrorDTO;
import com.example.CRUD_CLIENTES.exceptions.DatabaseException;
import com.example.CRUD_CLIENTES.exceptions.ResourceNotFoundExeception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO(Instant.now(), httpStatus.value(),
                "Dados invalidos", request.getRequestURI());
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            validationErrorDTO.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(httpStatus).body(validationErrorDTO);
    }
}
