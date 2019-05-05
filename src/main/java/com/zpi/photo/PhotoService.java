package com.zpi.photo;

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


    public Optional<Photo> findById(int id)
    {
        return photoRepository.findById(id);

    }


    public Photo save(Photo favourite)
    {
        return photoRepository.save(favourite);
    }


    public void deleteById(int id)
    {
        photoRepository.deleteById(id);
    }

}

