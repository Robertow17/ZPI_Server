package com.zpi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/services")
public class ServiceController
{
    @Autowired
    private ServiceService serviceService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Service service)
    {
        return ResponseEntity.ok(serviceService.save(service));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Service>> getAll()
    {
        return ResponseEntity.ok(serviceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Service> findById(@PathVariable(value = "id") int id)
    {
        Optional<Service> service = serviceService.findById(id);
        if(!service.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(service.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Service> update(@PathVariable(value = "id") int id, @Valid @RequestBody Service service)
    {
        if(!serviceService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(serviceService.save(service));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        if(!serviceService.findById(id).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        serviceService.deleteById(id);

        return ResponseEntity.ok().build();
    }


   /* //TEST
    @GetMapping("/all")
    public String getAllServices()
    {
        return "String z servera";

    }*/

}
