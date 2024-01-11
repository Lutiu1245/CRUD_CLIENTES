package com.example.CRUD_CLIENTES.controllers.handler;

import com.example.CRUD_CLIENTES.DTO.CustomErrorDTO;
import com.example.CRUD_CLIENTES.DTO.ValidationErrorDTODTO;
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
    public ResponseEntity<CustomErrorDTO> dataIntegrityViolationException(DatabaseException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        CustomErrorDTO customErrorDTO = new CustomErrorDTO(Instant.now(), httpStatus.value(),
                                  e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customErrorDTO);
    }

    @ExceptionHandler(ResourceNotFoundExeception.class)
    public ResponseEntity<CustomErrorDTO> resourceNotFoundExeception(ResourceNotFoundExeception e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        CustomErrorDTO customErrorDTO = new CustomErrorDTO(Instant.now(), httpStatus.value(),
                e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(customErrorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorDTO> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationErrorDTODTO validationErrorDTO = new ValidationErrorDTODTO(Instant.now(), httpStatus.value(),
                "Dados invalidos", request.getRequestURI());
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            validationErrorDTO.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(httpStatus).body(validationErrorDTO);
    }
}
