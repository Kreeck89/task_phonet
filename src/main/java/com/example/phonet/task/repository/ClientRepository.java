package com.example.phonet.task.repository;

import com.example.phonet.task.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * from clients where age < ?1", nativeQuery = true)
    List<Client> getAllClientsWithAgeUnderVal(int age);

}
