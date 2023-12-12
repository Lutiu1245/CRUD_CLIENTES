package com.example.CRUD_CLIENTES.services;

import com.example.CRUD_CLIENTES.DTO.ClientDTO;
import com.example.CRUD_CLIENTES.entities.Client;
import com.example.CRUD_CLIENTES.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        return new ClientDTO(client);
    }
}
