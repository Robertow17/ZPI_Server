package com.zpi.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Subcategory
{

    @Id
    @Column(length = 30)
    private String name;


    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.ALL)
    private List<Service> services = new ArrayList<>();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


}
