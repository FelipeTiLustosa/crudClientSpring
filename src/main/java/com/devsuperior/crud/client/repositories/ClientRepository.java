package com.devsuperior.crud.client.repositories;

import com.devsuperior.crud.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
