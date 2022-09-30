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
    //=  Transfert Methods    =
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
}