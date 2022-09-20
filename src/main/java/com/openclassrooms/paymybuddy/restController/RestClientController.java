package com.openclassrooms.paymybuddy.restController;

import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.service.ClientService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/clients")
public class RestClientController
{
    //==========================
    //=      Attributes        =
    //==========================
    private final ClientService clientService;

    //==========================
    //=      Constructor       =
    //==========================

    public RestClientController(ClientService clientService)
    {
        this.clientService = clientService;
    }

    //==========================
    //=      REST Methods      =
    //==========================

//    @GetMapping("/{id}")
//    public Client getClient(@PathVariable("id") Integer id)
//    {
//
//        return clientService.getClientById(id).get();
//    }

    @GetMapping("/{email}")
    public Client getClient(@PathVariable("email") String email)
    {
        return clientService.getClientByEmail(email).get();
    }
}