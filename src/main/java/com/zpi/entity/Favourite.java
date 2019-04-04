package com.zpi.entity;

import com.zpi.composite_key.FavouritePK;
import com.zpi.composite_key.PhotoPK;

import javax.persistence.*;

@Entity
public class Favourite
{
    @EmbeddedId
    private FavouritePK id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    private Service service;

    @MapsId("login")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login")
    private User user;

    private boolean isFavourite;


    public FavouritePK getId()
    {
        return id;
    }

    public void setId(FavouritePK id)
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public boolean isFavourite()
    {
        return isFavourite;
    }

    public void setFavourite(boolean favourite)
    {
        isFavourite = favourite;
    }
}

