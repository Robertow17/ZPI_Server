package com.zpi.favourite;


import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class FavouritePK implements Serializable
{
    private int id;
    private String login;

    public FavouritePK()
    {
    }

    public FavouritePK(int id, String login)
    {
        this.id = id;
        this.login = login;
    }


}

