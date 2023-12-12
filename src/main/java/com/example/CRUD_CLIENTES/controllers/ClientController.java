package com.example.CRUD_CLIENTES.controllers;

import com.example.CRUD_CLIENTES.DTO.ClientDTO;
import com.example.CRUD_CLIENTES.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping(value = "{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }
}
