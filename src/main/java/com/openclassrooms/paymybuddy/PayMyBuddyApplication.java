package com.openclassrooms.paymybuddy;

import com.openclassrooms.paymybuddy.dto.AngularClient;
import com.openclassrooms.paymybuddy.entities.Account;
import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.entities.Connection;
import com.openclassrooms.paymybuddy.service.AccountService;
import com.openclassrooms.paymybuddy.service.ClientService;
import com.openclassrooms.paymybuddy.service.ConnectionService;
import com.openclassrooms.paymybuddy.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class PayMyBuddyApplication implements CommandLineRunner
{

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ConnectionService connectionService;

    @Autowired
    private RestService restService;

    public static void main(String[] args)
    {
        SpringApplication.run(PayMyBuddyApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args)
    {
        //AngularClient(String name, String email, String password)
//        AngularClient angularClient= new AngularClient("Jenny", "Jenny@mail.ml", "123");
//
//        if(restService.createClient(angularClient))
//        {
//            System.out.println("**** Client Created ****");
//
//            Client client = clientService.getClientByEmail(angularClient.email()).get();
//            System.out.println("client name = "         + client.getName());
//            System.out.println("client id = "           + client.getId());
//            System.out.println("client email = "        + client.getEmail());
//            System.out.println("client roles = "        + client.getRoles());
//            System.out.println("client accountId = "    + client.getAccountId());
//            System.out.println("client balance = "      + client.getBalance());
//        }


//        Iterable<Client> clients = clientService.getClients();
//        clients.forEach(client -> System.out.println(client.getName() + " "  + client.getRoles()));
//        clients.forEach(client -> System.out.println(client.getConnections()));
//
//        Iterable<Account> accounts = accountService.getAccounts();
//        accounts.forEach(account -> System.out.println(account.getClient().getName() + " " + account.getAmount()));
    }
}