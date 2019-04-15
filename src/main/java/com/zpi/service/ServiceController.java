package com.zpi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ServiceDTO> create(@Valid @RequestBody ServiceDTO categoryDTO)
    {
        serviceService.save(ServiceMapper.INSTANCE.toService(categoryDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<ServiceDTO>> getAll()
    {
        return ResponseEntity.ok(ServiceMapper.INSTANCE.toServiceDTOs(serviceService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceDTO> findById(@PathVariable(value = "id") int id)
    {
        Optional<Service> service = serviceService.findById(id);

        if(!service.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(ServiceMapper.INSTANCE.toServiceDTO(service.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceDTO> update(@PathVariable(value = "id") int id, @Valid @RequestBody ServiceDTO serviceDTO)
    {
        Service service = ServiceMapper.INSTANCE.toService(serviceDTO);
        service.setId(id);
        serviceService.save(service);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serviceDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        serviceService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


   /* //TEST
    @GetMapping("/all")
    public String getAllServices()
    {
        return "String z servera";

    }*/

}
