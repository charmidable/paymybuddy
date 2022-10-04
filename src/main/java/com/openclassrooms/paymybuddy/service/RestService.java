package com.openclassrooms.paymybuddy.service;

import com.openclassrooms.paymybuddy.dto.AngularClient;
import com.openclassrooms.paymybuddy.dto.AngularTransaction;
import com.openclassrooms.paymybuddy.entities.Account;
import com.openclassrooms.paymybuddy.entities.Client;
import com.openclassrooms.paymybuddy.entities.Transaction;
import com.openclassrooms.paymybuddy.repository.AuthorityRepository;
import com.openclassrooms.paymybuddy.security.AuthenticationProviderService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class RestService
{
    //==========================
    //=      Attributes        =
    //==========================

    private final AuthenticationProviderService authenticationProviderService;
    private final AuthorityService              authorityService;
    private final TransactionService            transactionService;
    private final AccountService                accountService;
    private final ClientService                 clientService;


    //==========================
    //=      Constructor       =
    //==========================

    public RestService(AuthenticationProviderService authenticationProviderService, AuthorityService authorityService, TransactionService transactionService, AccountService accountService, ClientService clientService)
    {
        this.authenticationProviderService  = authenticationProviderService;
        this.transactionService             = transactionService;
        this.authorityService               = authorityService;
        this.accountService                 = accountService;
        this.clientService                  = clientService;
    }


    //==========================
    //=    Service Methods     =
    //==========================

    @Transactional
    public void createTransaction(AngularTransaction angularTransaction)
    {
        if(angularTransaction.payerAccountId() != angularTransaction.recipientAccountId())
        {
            Account payerAccount = accountService.getAccountById(angularTransaction.payerAccountId()).get();
            Account recipientAccount = accountService.getAccountById(angularTransaction.recipientAccountId()).get();

            Transaction transaction = new Transaction(
                                                        angularTransaction.amount(),
                                                        angularTransaction.description(),
                                                        payerAccount,
                                                        recipientAccount
                                                     );

            payerAccount.setBalance(payerAccount.getBalance()-angularTransaction.amount()*1.005f);

            recipientAccount.setBalance(recipientAccount.getBalance()+angularTransaction.amount());

            transactionService.save(transaction);
            accountService.save(payerAccount);
            accountService.save(recipientAccount);
        }
        else
        {
            Account payerAccount = accountService.getAccountById(angularTransaction.payerAccountId()).get();

            Transaction transaction = new Transaction(angularTransaction.amount(), angularTransaction.description(), payerAccount, payerAccount);

            if(angularTransaction.description().equals("Deposit"))
            {
                System.out.println("DEPOSIT");
                System.out.println("payerAccount.getBalance() : " + payerAccount.getBalance());
                System.out.println("angularTransaction.amount() : " + angularTransaction.amount());
                payerAccount.setBalance(payerAccount.getBalance() + angularTransaction.amount());
                System.out.println("payerAccount.getBalance() : " + payerAccount.getBalance());
            }
            else
            {
                payerAccount.setBalance(payerAccount.getBalance() - angularTransaction.amount());
            }

            transactionService.save(transaction);
            accountService.save(payerAccount);
        }
    }

    @Transactional
    public Account getTransactionsByAccountId(Integer accountId)
    {
        return accountService.getAccountById(accountId).get();
    }


    public boolean createClient(AngularClient angularClient)
    {
        Client client = Client.getNewClientWithAuthorityRoles();
        client.setName(angularClient.name());
        client.setEmail(angularClient.email());
        client.setPassword(authenticationProviderService.encodePassword(angularClient.password()));
        client.addAuthority(authorityService.findAuthorityByName("client").get());
        clientService.save(client);
        Account account = accountService.save(new Account(client));
        accountService.save(account);
        client.setAccount(account);
        clientService.save(client);
        return true;
    }
}