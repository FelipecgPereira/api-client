package com.devsuperiorbootcamp.apiclients.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperiorbootcamp.apiclients.entities.Client;

@Repository
public interface  ClientRepository extends JpaRepository<Client, Long> {

}
