package com.example.phonet.task.service;

import com.example.phonet.task.model.History;
import com.example.phonet.task.model.Transaction;

import java.util.List;

public interface HistoryService {

    List<History> getAllHistory(Transaction transaction);
}
