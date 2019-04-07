package com.zpi.favourite;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(o == null || getClass() != o.getClass())
            return false;
        FavouritePK that = (FavouritePK) o;
        return id == that.id && Objects.equals(login, that.login);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, login);
    }
}

