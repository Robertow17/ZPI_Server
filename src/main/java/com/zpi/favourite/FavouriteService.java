package com.zpi.favourite;


import com.zpi.category.Category;
import com.zpi.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FavouriteService
{
    @Autowired
    private FavouriteRepository favouriteRepository;


    public List<Favourite> findAll()
    {
        return favouriteRepository.findAll();
    }


    public Optional<Favourite> findById(int serviceId, String login)
    {
        return favouriteRepository.findById(new FavouritePK(serviceId, login));

    }


    public Favourite save(Favourite favourite)
    {
        return favouriteRepository.save(favourite);
    }


    public void deleteById(int serviceId, String login)
    {
        favouriteRepository.deleteById(new FavouritePK(serviceId, login));
    }

}
