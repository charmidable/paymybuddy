package com.openclassrooms.paymybuddy.entities;

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
    private BigDecimal balance;

    @OneToMany(mappedBy = "payerAccount")
    private List<Transaction> payers;

    @OneToMany(mappedBy = "recipientAccount")
    private List<Transaction> recipients;


    //=========================
    //=   Getters & Setters   =
    //=========================


    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public BigDecimal getBalance()
    {
        return balance;
    }

    public void setBalance(BigDecimal amount)
    {
        this.balance = amount;
    }

    public List<Transaction> getPayers()
    {
        return payers;
    }

    public void setPayers(List<Transaction> payers)
    {
        this.payers = payers;
    }

    public List<Transaction> getRecipients()
    {
        return recipients;
    }

    public void setRecipients(List<Transaction> recipients)
    {
        this.recipients = recipients;
    }

//    public List<Transaction> getTransactions()
//    {
//        return Stream.concat(
//                                recipients.stream().peek(transaction -> {
//                                            if(transaction.getRecipientAccount().getId() != this.getId() )
//                                            {
//                                                transaction.setConnectionName(transaction.getRecipientAccount().getClient().getName());
//                                            }
//                                            else
//                                            {
//                                                transaction.setConnectionName("");
//                                            }
//                                    System.out.println(transaction.getConnectionName());
//                                            transaction.setAmount(transaction.getTransactionAmount());
//                                        }
//                                ),
//
//                                payers    .stream().peek(transaction -> {
//                                            if(transaction.getPayerAccount().getId() != this.getId() )
//                                            {
//                                                transaction.setConnectionName(transaction.getPayerAccount().getClient().getName());
//                                            }
//                                            else
//                                            {
//                                                transaction.setConnectionName("");
//                                            }
//                                    System.out.println(transaction.getConnectionName());
//                                            transaction.setAmount(transaction.getTransactionAmount().negate());
//                                        }
//                                )
//                        ).sorted()
//                         .toList();
//    }

    public List<Transaction> getTransactions()
    {

        return Stream.concat(
                                recipients.stream().peek(transaction -> {
                                                                            transaction.setConnectionName(transaction.getRecipientAccount().getClient().getName());
                                                                            transaction.setAmount(transaction.getTransactionAmount());
                                                                        }),

                                payers    .stream().peek(transaction -> {
                                                                            transaction.setConnectionName(transaction.getRecipientAccount().getClient().getName());
                                                                            transaction.setAmount(transaction.getTransactionAmount().negate());
                                                                        }
                                                        )
                            ).sorted()
                             .toList();
    }
}