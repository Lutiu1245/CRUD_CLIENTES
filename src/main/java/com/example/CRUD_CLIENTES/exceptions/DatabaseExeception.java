package com.example.CRUD_CLIENTES.exceptions;

public class DatabaseExeception extends RuntimeException{
    public DatabaseExeception(String msg) {
        super(msg);
    }
}
