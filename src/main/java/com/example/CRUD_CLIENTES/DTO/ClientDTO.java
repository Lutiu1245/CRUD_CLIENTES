package com.example.CRUD_CLIENTES.DTO;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private double income;
    private LocalDate birthDate;
    private int children;

    public ClientDTO(Long id, String name, String cpf, double income, LocalDate birthDate, int children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO() {

    }

    public Long getId() {
        return id;
    }


    
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }
}
