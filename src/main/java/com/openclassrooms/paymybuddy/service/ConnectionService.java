package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.entities.Connection;
import com.openclassrooms.paymybuddy.repository.ConnectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConnectionService
{
    //==========================
    //=      Attributes        =
    //==========================
    private final ConnectionRepository connectionRepository;


    //==========================
    //=      Constructor       =
    //==========================

    public ConnectionService(ConnectionRepository connectionRepository)
    {
        this.connectionRepository = connectionRepository;
    }


    //==========================
    //=    Service  Methods    =
    //==========================

    public List<Connection> getAllConnections()
    {
        return connectionRepository.findAll();
    }
}
