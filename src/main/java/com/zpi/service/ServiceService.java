package com.zpi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceService
{
    @Autowired
    private ServiceRepository serviceRepository;


    public List<com.zpi.service.Service> findAll()
    {
        return serviceRepository.findAll();
    }


    public Optional<com.zpi.service.Service> findById(int id)
    {
        return serviceRepository.findById(id);

    }


    public com.zpi.service.Service save(com.zpi.service.Service service)
    {
        return serviceRepository.save(service);
    }


    public void deleteById(int id)
    {
        serviceRepository.deleteById(id);
    }

}
