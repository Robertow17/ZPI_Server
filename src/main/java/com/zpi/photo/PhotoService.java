package com.zpi.photo;


import com.zpi.favourite.Favourite;
import com.zpi.favourite.FavouritePK;
import com.zpi.favourite.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoService
{
    @Autowired
    private PhotoRepository photoRepository;


    public List<Photo> findAll()
    {
        return photoRepository.findAll();
    }


    public Optional<Photo> findById(int serviceId, String value)
    {
        return photoRepository.findById(new PhotoPK(serviceId, value));

    }


    public Photo save(Photo favourite)
    {
        return photoRepository.save(favourite);
    }


    public void deleteById(int serviceId, String value)
    {
        photoRepository.deleteById(new PhotoPK(serviceId, value));
    }

}

