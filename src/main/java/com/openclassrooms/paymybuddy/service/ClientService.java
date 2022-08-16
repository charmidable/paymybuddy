package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.Entities.Client;
import com.openclassrooms.paymybuddy.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService
{
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository)
    {
        this.clientRepository = clientRepository;
    }

    public Iterable<Client> getClients()
    {
        return clientRepository.findAll();
    }
}