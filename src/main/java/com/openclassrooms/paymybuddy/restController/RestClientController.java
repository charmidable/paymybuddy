package com.openclassrooms.paymybuddy.restController;

import com.openclassrooms.paymybuddy.dto.AngularClient;
import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.service.ClientService;
import com.openclassrooms.paymybuddy.service.RestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("api/clients")
public class RestClientController
{
    //==========================
    //=      Attributes        =
    //==========================
    private final ClientService clientService;
    private final RestService restService;

    //==========================
    //=      Constructor       =
    //==========================

    public RestClientController(ClientService clientService, RestService restService)
    {
        this.clientService = clientService;
        this.restService = restService;
    }

    //==========================
    //=      REST Methods      =
    //==========================

    @GetMapping("/{email}")
    @RolesAllowed("client")
    public Client getClient(@PathVariable("email") String email)
    {
        return clientService.getClientByEmail(email).get();
    }


    @PostMapping("new")
    public boolean newclient(@RequestBody AngularClient angularClient)
    {
        System.out.println("***** newclient CALLED ******");
        return restService.createClient(angularClient);
    }

}