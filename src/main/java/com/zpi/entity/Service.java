package com.zpi.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Service
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String localization;
    private String description;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_name", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_name", nullable = true)
    private Subcategory subcategory;

    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private WeddingHallDetails weddingHallDetails;

    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TransportDetails transportDetails;

    @OneToMany(mappedBy= "service",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy= "service",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Favourite> favourites = new ArrayList<>();


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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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


    public WeddingHallDetails getWeddingHallDetails()
    {
        return weddingHallDetails;
    }

    public void setWeddingHallDetails(WeddingHallDetails weddingHallDetails)
    {
        this.weddingHallDetails = weddingHallDetails;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public Subcategory getSubcategory()
    {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory)
    {
        this.subcategory = subcategory;
    }

    public TransportDetails getTransportDetails()
    {
        return transportDetails;
    }

    public void setTransportDetails(TransportDetails transportDetails)
    {
        this.transportDetails = transportDetails;
    }

    public List<Photo> getPhotos()
    {
        return photos;
    }

    public void setPhotos(List<Photo> photos)
    {
        this.photos = photos;
    }

    public List<Favourite> getFavourites()
    {
        return favourites;
    }

    public void setFavourites(List<Favourite> favourites)
    {
        this.favourites = favourites;
    }
}
