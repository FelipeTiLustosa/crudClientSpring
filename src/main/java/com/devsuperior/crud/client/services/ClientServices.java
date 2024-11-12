package com.devsuperior.crud.client.services;

import com.devsuperior.crud.client.dto.ClientDTO;
import com.devsuperior.crud.client.entities.Client;
import com.devsuperior.crud.client.repositories.ClientRepository;
import com.devsuperior.crud.client.services.exceptions.DatabaseException;
import com.devsuperior.crud.client.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository repository;

    @Transactional
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return  result.map(x -> new ClientDTO(x));
    }

    @Transactional(readOnly = true) // Esse parâmetro indica que o método não vai realizar alterações nos dados, apenas fazer consultas.
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado")
        );
        return new ClientDTO(client);
    }


    public  void copyDtoToEntity(ClientDTO dto, Client entity){
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildrean(dto.getChildrean());
    }
}
