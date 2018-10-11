package com.example.phonet.task.repository;

import com.example.phonet.task.model.History;
import com.example.phonet.task.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findAllByType(Transaction transaction);
}
