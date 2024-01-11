package com.example.CRUD_CLIENTES.services;

import com.example.CRUD_CLIENTES.DTO.ClientDTO;
import com.example.CRUD_CLIENTES.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {
    ClientDTO findById(Long id);
    Page<ClientDTO> findAll(Pageable pageable);
    ClientDTO insert(ClientDTO clientDTO);
    ClientDTO update(Long id, ClientDTO clientDTO);
    void delete(Long id);
    void copyDTO(Client client, ClientDTO clientDTO);
}
