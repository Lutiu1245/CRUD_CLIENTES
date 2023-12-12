package com.example.CRUD_CLIENTES.repositories;

import com.example.CRUD_CLIENTES.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Long> {
}
