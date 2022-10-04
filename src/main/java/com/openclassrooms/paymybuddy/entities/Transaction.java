package com.openclassrooms.paymybuddy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

@Entity
@Table(name="transaction")
public class Transaction implements Comparable<Transaction>
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private float transactionAmount;

    @Column(name = "description")
    private String description;

    @Column(name = "moment")
    private LocalDateTime moment;

    @ManyToOne
    @JoinColumn(name = "payer")
    private Account payerAccount;

    @ManyToOne
    @JoinColumn(name = "recipient")
    private Account recipientAccount;

    @Transient
    private String connectionName;

    @Transient
    private float amount;

    //=========================
    //=     Constructors      =
    //=========================


    public Transaction()
    {
    }

    public Transaction(float transactionAmount, String description, Account payerAccount, Account recipientAccount)
    {
        this.transactionAmount = transactionAmount;
        this.description = description;
        this.payerAccount = payerAccount;
        this.recipientAccount = recipientAccount;
        this.amount = amount;
        this.moment = LocalDateTime.now();
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
    public float getTransactionAmount()
    {
        return transactionAmount;
    }

    public void setTransactionAmount(float amount)
    {
        this.transactionAmount = amount;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    @JsonIgnore
    public Account getPayerAccount()
    {
        return payerAccount;
    }

    public void setPayerAccount(Account payer)
    {
        this.payerAccount = payer;
    }

    @JsonIgnore
    public Account getRecipientAccount()
    {
        return recipientAccount;
    }

    public void setRecipientAccount(Account recipient)
    {
        this.recipientAccount = recipient;
    }

    @JsonIgnore
    public LocalDateTime getMoment()
    {
        return moment;
    }

    public void setMoment(LocalDateTime moment)
    {
        this.moment = moment;
    }

    public String getConnectionName()
    {
        return this.connectionName;
    }

    public void setConnectionName(String connectionName)
    {
        this.connectionName = connectionName;
    }

    public float getAmount()
    {
        return amount;
    }

    public void setAmount(float amount)
    {
        this.amount = amount;
    }

    //=========================
    //=     Object Method     =
    //=========================

    @Override
    public int compareTo(Transaction o)
    {
        return Comparator.comparing(Transaction::getMoment)
                         .compare(o, this);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }
}