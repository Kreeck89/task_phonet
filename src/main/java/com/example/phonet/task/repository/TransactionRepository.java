package com.example.phonet.task.repository;

import com.example.phonet.task.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

//    List<Transaction> findAllByTypeAndId(Transaction transaction, Long clientId);

    List<Transaction> findAllByFrom(Long fromClientId);

    List<Transaction> findAllByTo(Long toClientId);
}
