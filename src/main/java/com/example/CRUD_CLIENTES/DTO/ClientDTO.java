package com.example.CRUD_CLIENTES.DTO;

import com.example.CRUD_CLIENTES.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    @Size(min = 3, max = 14, message = "Nome deve ter entre 3 e 14 caracteres")
    @NotBlank(message = "Campo de nome é obrigatório")
    private String name;
    @CPF(message = "CPF inválido")
    private String cpf;
    @Positive(message = "Renda deve ser uma valor positivo")
    private double income;
    @NotBlank()
    private LocalDate birthDate;
    @Positive(message = "Este campo deve ser positivo")
    private int children;

    public ClientDTO(Long id, String name, String cpf, double income, LocalDate birthDate, int children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
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
