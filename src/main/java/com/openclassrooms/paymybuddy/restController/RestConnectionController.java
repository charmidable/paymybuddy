package com.openclassrooms.paymybuddy.restController;

import com.openclassrooms.paymybuddy.dto.AngularConnection;
import com.openclassrooms.paymybuddy.dto.AngularTransaction;
import com.openclassrooms.paymybuddy.entities.Account;
import com.openclassrooms.paymybuddy.entities.Connection;
import com.openclassrooms.paymybuddy.service.ConnectionService;
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
        System.out.println("*** getAllConnections ***");
        return connectionService.getAllConnections();
    }


    @PostMapping()
    @RolesAllowed("client")
    public String newConnection(@RequestBody AngularConnection angularConnection)
    {
        System.out.println("*** newConnection ***");
        connectionService.newConnection(angularConnection);
        return "{\"result\" : \"ok\"}";
    }
}