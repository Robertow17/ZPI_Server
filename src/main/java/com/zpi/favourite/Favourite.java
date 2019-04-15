package com.zpi.favourite;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zpi.service.Service;
import com.zpi.user.User;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Favourite
{
    @EmbeddedId
    private FavouritePK id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_service")
    @JsonManagedReference
    private Service service;

    @MapsId("login")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_login")
    @JsonManagedReference
    private User user;

    @Column(columnDefinition = "boolean default true")
    private boolean isFavourite = true;


    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;
}

