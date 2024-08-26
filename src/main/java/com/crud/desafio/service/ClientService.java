package com.crud.desafio.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.crud.desafio.dto.ClientDTO;

public interface ClientService {
    Page<ClientDTO> findAll(Pageable pageable);
    ClientDTO findById(Long id);
    ClientDTO save(ClientDTO clientDTO);
    ClientDTO update(Long id, ClientDTO clientDTO);
    void delete(Long id);
}
