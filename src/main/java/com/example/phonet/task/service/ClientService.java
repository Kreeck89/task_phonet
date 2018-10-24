package com.example.phonet.task.service;

import com.example.phonet.task.model.Client;

import java.util.List;

public interface ClientService {

    Client create(Client client);

    Client update(Client client);

    Client getById(Long id);

    List<Client> getAllClientsWithCriteria();
}
