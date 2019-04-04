package com.zpi.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TransportDetails
{

    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @MapsId
    private Service service;

    @Column(nullable = true)
    private int maxSittingPlaces;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Service getService()
    {
        return service;
    }

    public void setService(Service service)
    {
        this.service = service;
    }

    public int getMaxSittingPlaces()
    {
        return maxSittingPlaces;
    }

    public void setMaxSittingPlaces(int maxSittingPlaces)
    {
        this.maxSittingPlaces = maxSittingPlaces;
    }
}
