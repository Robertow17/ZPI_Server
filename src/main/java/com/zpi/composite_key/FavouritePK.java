package com.zpi.composite_key;


import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FavouritePK implements Serializable
{
    private int id;
    private String login;

}

