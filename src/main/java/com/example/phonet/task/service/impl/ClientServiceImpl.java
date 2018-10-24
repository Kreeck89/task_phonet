package com.example.phonet.task.service.impl;

import com.example.phonet.task.model.Client;
import com.example.phonet.task.repository.ClientRepository;
import com.example.phonet.task.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client create(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<Client> getAllClientsWithCriteria() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        return null;
    }
}
