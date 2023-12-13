package com.example.CRUD_CLIENTES.DTO;

public class FieldMessageDTO {
    private String field;
    private String msg;

    public FieldMessageDTO(String field, String msg) {
        this.field = field;
        this.msg = msg;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
