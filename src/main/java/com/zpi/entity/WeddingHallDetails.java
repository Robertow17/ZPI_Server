package com.zpi.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class WeddingHallDetails
{

    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @MapsId
    private Service service;

    @Column(nullable = true)
    private boolean canSleep;

    @Column(nullable = true)
    private int maxNumberOfGuests;


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

    public boolean isCanSleep()
    {
        return canSleep;
    }

    public void setCanSleep(boolean canSleep)
    {
        this.canSleep = canSleep;
    }

    public int getMaxNumberOfGuests()
    {
        return maxNumberOfGuests;
    }

    public void setMaxNumberOfGuests(int maxNumberOfGuests)
    {
        this.maxNumberOfGuests = maxNumberOfGuests;
    }
}
