package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;


@Entity
@Table(name="client")
public class Connection
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "client")
    private Account account;


    //=========================
    //=     Constructors      =
    //=========================


    public Connection()
    {
    }

//    public Connection(Integer id, String name, String email, Account account)
//    {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.account = account;
//    }


    //=========================
    //=   Getters & Setters   =
    //=========================

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public Integer getClientId()
    {
        return id;
    }

    public Integer getAccountId()
    {
        return account.getId();
    }



    //  =========================
    //  =    Object Methods     =
    //  =========================


    @Override
    public String toString()
    {
        return "Client{" +
                "name= '" + name + '\'' +
                "ClientId: "     + getClientId() +
                "AccountId: "    + getAccountId() +
                '}';
    }
}