package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public void addConnection(int clientId, int connectId)
    {
        clientRepository.addConnection(clientId, connectId);
    }

    public Optional<Client> getClientByEmail(String email)
    {
        return clientRepository.findClientByEmail(email);
    }

    public Optional<Client> getClientById(Integer id)
    {
        return clientRepository.findById(id);
    }

    public Client save(Client client)
    {
        return clientRepository.save(client);
    }
}