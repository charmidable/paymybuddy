package com.openclassrooms.paymybuddy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;


@Entity
@Table(name="account")
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "client")
    private Client client;

    @Column(name = "balance")
    private float balance;

    @OneToMany(mappedBy = "payerAccount")
    private List<Transaction> payers;

    @OneToMany(mappedBy = "recipientAccount")
    private List<Transaction> recipients;


    //=========================
    //=     Constructors      =
    //=========================

    public Account()
    {
        this.balance = 0;
    }

    public Account(Client client)
    {
        this.balance = 0;
        this.client = client;
    }


    //=========================
    //=   Getters & Setters   =
    //=========================

    @JsonIgnore
    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
    @JsonIgnore
    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public float getBalance()
    {
        return balance;
    }

    public void setBalance(float amount)
    {
        this.balance = amount;
    }


    @JsonIgnore
    public List<Transaction> getPayers()
    {
        return payers;
    }

    public void setPayers(List<Transaction> payers)
    {
        this.payers = payers;
    }

    @JsonIgnore
    public List<Transaction> getRecipients()
    {
        return recipients;
    }


    public void setRecipients(List<Transaction> recipients)
    {
        this.recipients = recipients;
    }


    //============================
    //=  Data Transfert Methods  =
    //============================

    public List<Transaction> getTransactions()
    {
        return Stream.concat(
                                recipients.stream().peek(transaction -> {
                                                                            if(transaction.getRecipientAccount().getId() == transaction.getPayerAccount().getId())
                                                                            {
                                                                                transaction.setConnectionName("");

                                                                                if(transaction.getDescription().equals("Withdrawal"))                                                                                {
                                                                                    transaction.setAmount(transaction.getTransactionAmount()*(-1));
                                                                                }
                                                                                else
                                                                                {
                                                                                    transaction.setAmount(transaction.getTransactionAmount());
                                                                                }
                                                                            }
                                                                            else
                                                                            {
                                                                                transaction.setConnectionName(transaction.getPayerAccount().getClient().getName());
                                                                                transaction.setAmount(transaction.getTransactionAmount());
                                                                            }
                                                                        }),

                                payers    .stream().peek(transaction -> {
                                                                            if(transaction.getRecipientAccount().getId() == transaction.getPayerAccount().getId())
                                                                            {
                                                                                transaction.setConnectionName("");

                                                                                if(transaction.getDescription().equals("Withdrawal"))
                                                                                {
                                                                                    transaction.setAmount(transaction.getTransactionAmount()*(-1));
                                                                                }
                                                                                else
                                                                                {
                                                                                    transaction.setAmount(transaction.getTransactionAmount());
                                                                                }
                                                                            }
                                                                            else
                                                                            {
                                                                                transaction.setConnectionName(transaction.getRecipientAccount().getClient().getName());
                                                                                transaction.setAmount(transaction.getTransactionAmount()*(-1));
                                                                            }
                                                                        }
                                                        )
                            ).sorted()
                             .distinct()
                             .toList();
    }
}