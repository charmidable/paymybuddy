package com.openclassrooms.paymybuddy;

import com.openclassrooms.paymybuddy.entities.Account;
import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.entities.Connection;
import com.openclassrooms.paymybuddy.service.AccountService;
import com.openclassrooms.paymybuddy.service.ClientService;
import com.openclassrooms.paymybuddy.service.ConnectionService;
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

    public static void main(String[] args)
    {
        SpringApplication.run(PayMyBuddyApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args)
    {
//        Iterable<Client> clients = clientService.getClients();
//        clients.forEach(client -> System.out.println(client.getName() + " "  + client.getRoles()));
//        clients.forEach(client -> System.out.println(client.getConnections()));
//
//        Iterable<Account> accounts = accountService.getAccounts();
//        accounts.forEach(account -> System.out.println(account.getClient().getName() + " " + account.getAmount()));
    }
}