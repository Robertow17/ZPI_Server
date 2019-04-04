package com.zpi.entity;

import com.zpi.composite_key.PhotoPK;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Photo
{

    @EmbeddedId
    private PhotoPK id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    private Service service;


    public Service getService()
    {
        return service;
    }

    public void setService(Service service)
    {
        this.service = service;
    }
}

/*
@Entity
public class Photo
{

    @Embeddable
    private class PhotoPK implements Serializable
    {

        private int id;
        private String value;


    }

    @EmbeddedId
  *//*  @AttributeOverrides({
            @AttributeOverride(
                    name = "id",
                    column = @Column(name = "id_service")),
            @AttributeOverride(
                    name = "value",
                    column = @Column(name = "value"))
    })*//*
    private PhotoPK pk;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    private Service service;




    public Service getService()
    {
        return service;
    }

    public void setService(Service service)
    {
        this.service = service;
    }
}*/
