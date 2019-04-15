package com.zpi.service;

import com.zpi.transport_details.TransportDetailsDTO;
import com.zpi.wedding_hall_details.WeddingHallDetailsDTO;
import lombok.Data;


@Data
public class ServiceDTO
{
    private int id;
    private String name;
    private String localization;
    private String description;
    private String phoneNumber;
    private String email;
    private String category;
    private String subcategory;
    private WeddingHallDetailsDTO weddingHallDetails;
    private TransportDetailsDTO transportDetails;


}
