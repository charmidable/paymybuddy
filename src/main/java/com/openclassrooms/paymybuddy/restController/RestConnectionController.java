package com.openclassrooms.paymybuddy.restController;

import com.openclassrooms.paymybuddy.service.ConnectionService;
import com.openclassrooms.paymybuddy.dto.AngularConnection;
import com.openclassrooms.paymybuddy.entities.Connection;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
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


    @GetMapping("all")
    public List<Connection> getAllConnections()
    {
        return connectionService.getAllConnections();
    }


    @PostMapping()
    @RolesAllowed("client")
    public String newConnection(@RequestBody AngularConnection angularConnection)
    {
        connectionService.newConnection(angularConnection);
        return "{\"result\" : \"ok\"}";
    }
}