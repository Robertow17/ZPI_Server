package com.zpi.service;

import com.zpi.category.CategoryDTO;
import com.zpi.photo.PhotoDTO;
import com.zpi.subcategory.SubcategoryDTO;
import com.zpi.transport_details.TransportDetailsDTO;
import com.zpi.wedding_hall_details.WeddingHallDetailsDTO;
import lombok.Data;

import java.util.List;


@Data
public class ServiceDTO
{
    private int id;
    private String name;
    private String localization;
    private String description;
    private String phoneNumber;
    private String email;
    private SubcategoryDTO subcategory;
    private CategoryDTO category;
    private WeddingHallDetailsDTO weddingHallDetails;
    private TransportDetailsDTO transportDetails;
    private List<PhotoDTO> photos;


}


