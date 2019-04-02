package com.zpi.controller;


import com.zpi.entity.Service;
import com.zpi.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/services")
public class ServiceController
{
    @Autowired
    private ServiceRepository serviceRepository;


//    @GetMapping("/all")
//    public List<Service> getAllServices()
//    {
//        System.out.print("sdsds");
//        return null;
//
//    }

        @GetMapping("/all")
        public String getAllServices()
        {
            return "String z servera";

        }

}
