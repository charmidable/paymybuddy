package com.openclassrooms.paymybuddy.restController;

import com.openclassrooms.paymybuddy.dto.AngularTransaction;
import com.openclassrooms.paymybuddy.entities.Account;
import com.openclassrooms.paymybuddy.service.RestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping("api/transactions")
public class RestTransactionController
{
    //==========================
    //=      Attributes        =
    //==========================
    private final RestService restService;


    //==========================
    //=      Constructor       =
    //==========================

    public RestTransactionController(RestService restService)
    {
        this.restService = restService;
    }


    //==========================
    //=      REST Methods      =
    //==========================

    @PostMapping()
    @RolesAllowed("client")
    public Account newTransaction(@RequestBody AngularTransaction angularTransaction)
    {
        System.out.println("RestTransactionController.newTransaction CALLED");
        restService.createTransaction(angularTransaction);
        return restService.getTransactionsByAccountId(angularTransaction.payerAccountId());
    }
}