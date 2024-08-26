package com.crud.desafio.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crud.desafio.dto.ClientDTO;
import com.crud.desafio.entity.Client;
import com.crud.desafio.repository.ClientRepository;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Page<ClientDTO> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(client -> modelMapper.map(client, ClientDTO.class));
    }

    @Override
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id " + id));
        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client = modelMapper.map(clientDTO, Client.class);
        client = clientRepository.save(client);
        return modelMapper.map(client, ClientDTO.class);
    }

    @Override
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        // Obtenha o cliente existente do banco de dados
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id " + id));

        // Atualize os campos do cliente existente com os valores do DTO
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());

        // Salve a entidade atualizada no banco de dados
        client = clientRepository.save(client);

        // Retorne o DTO atualizado
        return modelMapper.map(client, ClientDTO.class);
    }


    @Override
    public void delete(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id " + id));
        clientRepository.delete(client);
    }
}
