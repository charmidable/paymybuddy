package com.openclassrooms.paymybuddy.restController;

import com.openclassrooms.paymybuddy.entities.Connection;
import com.openclassrooms.paymybuddy.service.ConnectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/connections")
public class RestConnectionController
{
    //==========================
    //=      Attributes        =
    //==========================
    private final ConnectionService connectionService;


    //==========================
    //=      Constructor       =
    //==========================

    public RestConnectionController(ConnectionService connectionService)
    {
        this.connectionService = connectionService;
    }


    //==========================
    //=      REST Methods      =
    //==========================

    @GetMapping
    public List<Connection> getAllConnections()
    {
        return connectionService.getAllConnections();
    }
}