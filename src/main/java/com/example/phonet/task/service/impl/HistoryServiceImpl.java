package com.example.phonet.task.service.impl;

import com.example.phonet.task.model.History;
import com.example.phonet.task.model.Transaction;
import com.example.phonet.task.repository.HistoryRepository;
import com.example.phonet.task.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Autowired
    public HistoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<History> getAllHistory(Transaction transaction) {
        return historyRepository.findAllByType(transaction);
    }
}
