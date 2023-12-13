package com.example.CRUD_CLIENTES.services;

import com.example.CRUD_CLIENTES.DTO.ClientDTO;
import com.example.CRUD_CLIENTES.entities.Client;
import com.example.CRUD_CLIENTES.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clientPage = clientRepository.findAll(pageable);
        return clientPage.map(ClientDTO::new);
    }

    @Transactional()
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        copyDTO(client, clientDTO);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional()
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        Client client = clientRepository.getReferenceById(id);
        copyDTO(client, clientDTO);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
    public void copyDTO(Client client, ClientDTO clientDTO) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }
}
