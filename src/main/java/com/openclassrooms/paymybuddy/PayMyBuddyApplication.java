package com.openclassrooms.paymybuddy;

import com.openclassrooms.paymybuddy.Entities.Account;
import com.openclassrooms.paymybuddy.Entities.Client;
import com.openclassrooms.paymybuddy.repository.ClientRepository;
import com.openclassrooms.paymybuddy.service.AccountService;
import com.openclassrooms.paymybuddy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class PayMyBuddyApplication implements CommandLineRunner
{

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountService accountService;

    public static void main(String[] args)
    {
        SpringApplication.run(PayMyBuddyApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args)
    {
        Iterable<Client> clients = clientService.getClients();
        clients.forEach(client -> System.out.println(client.getName() + " " + client.getConnections() + " " + client.getRoles()));

//        Iterable<Account> accounts = accountService.getAccounts();
//        accounts.forEach(account -> System.out.println(account.getClient().getName() + " " + account.getAmount()));
    }
}