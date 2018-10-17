package com.example.phonet.task.service.impl;

import com.example.phonet.task.model.Transaction;
import com.example.phonet.task.model.dto.TransactionDto;
import com.example.phonet.task.repository.TransactionRepository;
import com.example.phonet.task.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionDto> getAllCreditHistory(Long fromClientId) {
        List<Transaction> allByFrom = transactionRepository.findAllByFrom(fromClientId);
        return getHistory(allByFrom);
    }

    @Override
    public List<TransactionDto> getAllDebitHistory(Long toClientId) {
        List<Transaction> allByTo = transactionRepository.findAllByTo(toClientId);
        return getHistory(allByTo);
    }

    @Override
    public Transaction create(Transaction transaction) {
        return transactionRepository.saveAndFlush(transaction);
    }

    private List<TransactionDto> getHistory(List<Transaction> allByFrom) {
        List<TransactionDto> history = new ArrayList<>();
        for (Transaction transaction : allByFrom) {
            TransactionDto transactionDto = new TransactionDto();
            transactionDto.setDate(transaction.getDate());
            transactionDto.setFrom(transaction.getFrom());
            transactionDto.setTo(transaction.getTo());
            transactionDto.setValue(transaction.getValue());
            history.add(transactionDto);
        }
        return history;
    }
}
