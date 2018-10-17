package com.example.phonet.task.service;

import com.example.phonet.task.model.Transaction;
import com.example.phonet.task.model.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    List<TransactionDto> getAllCreditHistory(Long fromClientId);

    List<TransactionDto> getAllDebitHistory(Long toClientId);

    Transaction create(Transaction transaction);
}
