package com.openclassrooms.paymybuddy.Entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

    @Column(name = "amount")
    private BigDecimal amount;

    @OneToMany(mappedBy = "payer")
    private List<Transaction> payers;

    @OneToMany(mappedBy = "recipient")
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

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
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
}