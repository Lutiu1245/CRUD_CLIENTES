package com.example.CRUD_CLIENTES.exceptions;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String msg) {
        super(msg);
    }
}
