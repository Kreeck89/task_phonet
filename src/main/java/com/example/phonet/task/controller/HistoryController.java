package com.example.phonet.task.controller;

import com.example.phonet.task.model.Client;
import com.example.phonet.task.model.History;
import com.example.phonet.task.model.Transaction;
import com.example.phonet.task.service.HistoryService;
import com.example.phonet.task.util.exception.NegativeAmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/balance")
public class HistoryController {

    private final HistoryService historyService;

    @Autowired
    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping(value = "/debit")
    public List<History> getHistoryByTypeDebit() {
        return historyService.getAllHistory(Transaction.DEBIT);
    }

    @GetMapping(value = "/credit")
    public List<History> getHistoryByTypeCredit() {
        return historyService.getAllHistory(Transaction.CREDIT);
    }

    @PostMapping(value = "/transaction")
    public void transaction(@RequestBody Client client, @RequestParam Long toId,
                            @RequestParam Transaction transactionType, @RequestParam Double value) throws NegativeAmountException {
        Double clientBalance = 0.0;
        if (transactionType.equals(Transaction.CREDIT)) {
            clientBalance = client.getBalance().getCredit();
        } else {
            clientBalance = client.getBalance().getDebit();
        }

        if (clientBalance < value) {
            throw new NegativeAmountException("Balance of your wallet under then value of your transaction");
        } else {
            /*
            * Вычитаем из баланса известного сумму и обновляем сущность методом update или fetch(надо добавить в репозиторий)
            * Потом находим по id клиента и обновляем его основноц балланс;
            * И созадем History, заполняем поля и добавляем в таблицу новую историю транзакции.
            *
            * Не успеваю дописать.
            * */
        }
    }
}
