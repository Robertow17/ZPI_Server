package com.zpi.favourite;


import com.zpi.service.ServiceDTO;
import com.zpi.user.UserDTO;
import lombok.Data;

@Data
public class FavouriteDTO
{
    private ServiceDTO service;
    private UserDTO user;
    private boolean isFavourite;

}

