package com.example.CRUD_CLIENTES.exceptions;

public class ResourceNotFoundExeception extends RuntimeException{
    public ResourceNotFoundExeception(String msg) {
        super(msg);
    }
}
