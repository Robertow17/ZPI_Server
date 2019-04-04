package com.zpi.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category
{
    @Id
    @Column(length = 20)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Service> services = new ArrayList<>();


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Service> getServices()
    {
        return services;
    }

    public void setServices(List<Service> services)
    {
        this.services = services;
    }
}
