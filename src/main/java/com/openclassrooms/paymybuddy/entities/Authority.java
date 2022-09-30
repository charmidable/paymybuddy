package com.openclassrooms.paymybuddy.entities;

import javax.persistence.*;

@Entity
@Table(name="authority")
public class Authority
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;


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

    @Override
    public String toString()
    {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }
}