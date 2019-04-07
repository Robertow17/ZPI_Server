package com.zpi.service;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.zpi.category.Category;
import com.zpi.favourite.Favourite;
import com.zpi.photo.Photo;
import com.zpi.subcategory.Subcategory;
import com.zpi.transport_details.TransportDetails;
import com.zpi.wedding_hall_details.WeddingHallDetails;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_name", nullable = false)
    @JsonManagedReference
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_name", nullable = true)
    @JsonManagedReference
    private Subcategory subcategory;

    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private WeddingHallDetails weddingHallDetails;

    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TransportDetails transportDetails;

    @OneToMany(mappedBy= "service",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Photo> photos = new ArrayList<>();

    @OneToMany(mappedBy= "service",  cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Favourite> favourites = new ArrayList<>();


}
