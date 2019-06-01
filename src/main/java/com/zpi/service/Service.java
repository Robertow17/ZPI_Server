package com.zpi.service;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zpi.category.Category;
import com.zpi.favourite.Favourite;
import com.zpi.photo.Photo;
import com.zpi.subcategory.Subcategory;
import com.zpi.transport_details.TransportDetails;
import com.zpi.account.Account;
import com.zpi.wedding_hall_details.WeddingHallDetails;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
public class Service
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_name", nullable = true)
    @JsonManagedReference
    private Subcategory subcategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_name", nullable = false)
    @JsonManagedReference
    private Category category;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wedding_hall_details")
    private WeddingHallDetails weddingHallDetails;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_transport_details")
    private TransportDetails transportDetails;

    @OneToMany(mappedBy= "service",  cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy= "service",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Favourite> favourites = new ArrayList<>();

    @OneToMany(mappedBy= "service",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Account> accounts = new ArrayList<>();

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updatedAt;

}
