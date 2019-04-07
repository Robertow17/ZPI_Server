package com.zpi.favourite;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zpi.service.Service;
import com.zpi.user.User;
import lombok.Data;

import javax.persistence.*;

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

    private boolean isFavourite;

}

