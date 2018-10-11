package com.example.phonet.task.repository;

import com.example.phonet.task.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
