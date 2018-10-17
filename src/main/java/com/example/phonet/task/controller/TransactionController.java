package com.example.phonet.task.controller;

import com.example.phonet.task.model.Client;
import com.example.phonet.task.model.Transaction;
import com.example.phonet.task.model.dto.ClientDto;
import com.example.phonet.task.model.dto.TransactionDto;
import com.example.phonet.task.service.ClientService;
import com.example.phonet.task.service.TransactionService;
import com.example.phonet.task.exception.NegativeAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/balance")
public class TransactionController {

    private final TransactionService transactionService;
    private final ClientService clientService;

    @Autowired
    public TransactionController(TransactionService transactionService, ClientService clientService) {
        this.transactionService = transactionService;
        this.clientService = clientService;
    }

    @GetMapping(value = "/debit")
    public List<TransactionDto> getHistoryByTypeDebit(@RequestParam Long clientId) {
        return transactionService.getAllDebitHistory(clientId);
    }

    @GetMapping(value = "/credit")
    public List<TransactionDto> getHistoryByTypeCredit(@RequestParam Long clientId) {
        return transactionService.getAllCreditHistory(clientId);
    }

    @PostMapping(value = "/transaction")
    public void transaction(@RequestBody ClientDto client) throws NegativeAmountException {
        Double clientBalance = client.getBalance();
        if (clientBalance == null || clientBalance < client.getTransactionValue()) {
            throw new NegativeAmountException("Balance of your wallet under than value of your transaction");
        } else {
            Client creditClient = clientService.getById(client.getId());
            Client debitClient = clientService.getById(client.getToClientId());

            creditClient.setBalance(creditClient.getBalance() - client.getTransactionValue());
            debitClient.setBalance(debitClient.getBalance() + client.getTransactionValue());

            clientService.update(creditClient);
            clientService.update(debitClient);

            Transaction transaction = new Transaction();
            transaction.setDate(LocalDate.now());
            transaction.setClient(creditClient);
            transaction.setFrom(creditClient.getId());
            transaction.setTo(client.getToClientId());
            transaction.setValue(client.getTransactionValue());
            transactionService.create(transaction);
        }
    }
}
