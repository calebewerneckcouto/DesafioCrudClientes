package com.crud.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.desafio.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
