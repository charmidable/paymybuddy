package com.openclassrooms.paymybuddy.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
public class Client
{
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

    @ManyToMany
    @JoinTable
    (
        name               = "connection",
        joinColumns        = @JoinColumn(name="connect"),
        inverseJoinColumns = @JoinColumn(name="client")
    )
    private List<Client> connections;



    @OneToOne(mappedBy = "client")
    private Account account;

    @ManyToMany
    @JoinTable
    (
        name               = "role",
        joinColumns        = @JoinColumn(name="client"),
        inverseJoinColumns = @JoinColumn(name="authority")
    )
    private List<Authority> roles;


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

    public List<Client> getConnections()
    {
        return connections;
    }

    public void setConnections(List<Client> connection)
    {
        this.connections = connection;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

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