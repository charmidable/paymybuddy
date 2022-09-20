package com.openclassrooms.paymybuddy.restController;

import com.openclassrooms.paymybuddy.dto.AngularTransaction;
import com.openclassrooms.paymybuddy.service.RestService;
import org.springframework.web.bind.annotation.*;


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
//    @GetMapping()
//    public void newTransaction()
//    {
//        System.out.println("******* Bonjour **********");
//    }

//    @PostMapping()
//    public void newTransaction(@RequestBody AngularTransaction angularTransaction)
//    {
//        System.out.println("RestTransactionController.newTransaction CALLED");
//        System.out.println( "angularTransaction.amount() : " + angularTransaction.amount() );
//        System.out.println( "angularTransaction.description() : " + angularTransaction.description() );
//        System.out.println( "angularTransaction.payerAccountId() : " + angularTransaction.payerAccountId() );
//        System.out.println( "angularTransaction.recipientAccountId() : " + angularTransaction.recipientAccountId() );
//
//        restService.save(angularTransaction);
//    }

    @PostMapping()
    public void newTransaction()
    {

        System.out.println("***** @PostMapping() *******");
//        restService.save(angularTransaction);
    }
}