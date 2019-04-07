package com.zpi.wedding_hall_details;


import com.zpi.category.Category;
import com.zpi.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeddingHallDetailsService
{
    @Autowired
    private WeddingHallDetailsRepository weddingHallDetailsRepository;


    public List<WeddingHallDetails> findAll()
    {
        return weddingHallDetailsRepository.findAll();
    }


    public Optional<WeddingHallDetails> findById(int id)
    {
        return weddingHallDetailsRepository.findById(id);

    }


    public WeddingHallDetails save(WeddingHallDetails weddingHallDetails)
    {
        return weddingHallDetailsRepository.save(weddingHallDetails);
    }


    public void deleteById(int id)
    {
        weddingHallDetailsRepository.deleteById(id);
    }
}
