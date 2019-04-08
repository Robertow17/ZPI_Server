package com.zpi.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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


//PRZYKLAD DO ZDJEC
    @RequestMapping(value = "/Image/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage() throws IOException {

//        BufferedImage bImage = ImageIO.read(new File("\\com\\zpi\\controller\\beautiful-beauty-blue-414612.jpg"));


        BufferedImage bImage = ImageIO.read(new File( "C:\\Users\\Asus\\Desktop\\zdjecia\\zdj1.jpg"));

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bImage, "jpg", bos );

        byte [] data = bos.toByteArray();

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(data);
    }


}
