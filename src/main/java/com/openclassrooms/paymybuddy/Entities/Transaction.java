package com.openclassrooms.paymybuddy.Entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="transaction")
public class Transaction
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    BigDecimal amount;

    @Column(name = "description")
    String description;

    @ManyToOne
    @JoinColumn(name = "payer")
    Account payer;

    @ManyToOne
    @JoinColumn(name = "recipient")
    Account recipient;


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

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Account getPayer()
    {
        return payer;
    }

    public void setPayer(Account payer)
    {
        this.payer = payer;
    }

    public Account getRecipient()
    {
        return recipient;
    }

    public void setRecipient(Account recipient)
    {
        this.recipient = recipient;
    }
}