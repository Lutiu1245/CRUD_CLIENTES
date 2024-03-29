package com.example.CRUD_CLIENTES.DTO;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTODTO extends CustomErrorDTO {
    private final List<FieldMessageDTO> fieldMessageDTOS = new ArrayList<>();

    public ValidationErrorDTODTO(Instant instant, Integer status, String error, String path) {
        super(instant, status, error, path);
    }

    public List<FieldMessageDTO> getFieldMessageDTOS() {
        return fieldMessageDTOS;
    }

    public void addError(String field, String msg) {
        fieldMessageDTOS.add(new FieldMessageDTO(field, msg));
    }
}
