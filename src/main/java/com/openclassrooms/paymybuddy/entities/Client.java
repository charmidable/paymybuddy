package com.openclassrooms.paymybuddy.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="client")
public class Client
{
    //=========================
    //=      Attributes       =
    //=========================
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToOne(mappedBy = "client")
    private Account account;


    @ManyToMany//(fetch = FetchType.EAGER)
    @JoinTable
    (
        name               = "connection",
        joinColumns        = @JoinColumn(name="client"),
        inverseJoinColumns = @JoinColumn(name="connect")
    )
    private List<Connection> connections;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    (
        name               = "role",
        joinColumns        = @JoinColumn(name="client"),
        inverseJoinColumns = @JoinColumn(name="authority")
    )
    private List<Authority> roles;

    //=========================
    //=      Constructor      =
    //=========================

    public Client()
    {
    }

    public static Client getNewClientWithAuthorityRoles()
    {
        Client client = new Client();
        client.setRoles(new ArrayList<Authority>());
        return client;
    }


    //===========================
    //=     Business Method     =
    //===========================

    public void addAuthority(Authority authority)
    {
        this.getRoles().add(authority);
    }


    //===========================
    //=  Data Transfert Method  =
    //===========================

    public List<Transaction> getTransactions()
    {
        return account.getTransactions();
    }

    public BigDecimal getBalance()
    {
        return account.getBalance();
    }


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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @JsonIgnore
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Transactional
    public List<Connection> getConnections()
    {
        return connections;
    }

    public void setConnections(List<Connection> connection)
    {
        this.connections = connection;
    }

    @JsonIgnore
    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public Integer getAccountId()
    {
        return account.getId();
    }

    @JsonIgnore
    public List<Authority> getRoles()
    {
        return roles;
    }

    public void setRoles(List<Authority> role)
    {
        this.roles = role;
    }


    //  =========================
    //  =    Object Methods     =
    //  =========================

    @Override
    public String toString()
    {
        return "Client{" +
                "name='" + name + '\'' +
                '}';
    }
}