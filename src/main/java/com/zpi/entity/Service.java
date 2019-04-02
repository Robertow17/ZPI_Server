package com.zpi.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
public class Service
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String localization;
    private int maxNumberOfGuests;
    private boolean canSleep, isFavourite;
    private String description;
    private ArrayList<Integer> photos;
    private String phoneNumber;
    private String email;
    private String subcategory;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocalization()
    {
        return localization;
    }

    public void setLocalization(String localization)
    {
        this.localization = localization;
    }

    public int getMaxNumberOfGuests()
    {
        return maxNumberOfGuests;
    }

    public void setMaxNumberOfGuests(int maxNumberOfGuests)
    {
        this.maxNumberOfGuests = maxNumberOfGuests;
    }

    public boolean isCanSleep()
    {
        return canSleep;
    }

    public void setCanSleep(boolean canSleep)
    {
        this.canSleep = canSleep;
    }

    public boolean isFavourite()
    {
        return isFavourite;
    }

    public void setFavourite(boolean favourite)
    {
        isFavourite = favourite;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public ArrayList<Integer> getPhotos()
    {
        return photos;
    }

    public void setPhotos(ArrayList<Integer> photos)
    {
        this.photos = photos;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getSubcategory()
    {
        return subcategory;
    }

    public void setSubcategory(String subcategory)
    {
        this.subcategory = subcategory;
    }
}
