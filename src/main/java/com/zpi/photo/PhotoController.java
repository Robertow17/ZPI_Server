package com.zpi.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path = "/photos")
public class PhotoController
{

    @Autowired
    private PhotoService photoService;


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Photo photo)
    {
        return ResponseEntity.ok(photoService.save(photo));
    }


    @GetMapping("/all")
    public ResponseEntity<List<Photo>> getAll()
    {
        return ResponseEntity.ok(photoService.findAll());
    }

    @GetMapping("/{id}/{value}")
    public ResponseEntity<Photo> findById(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value)
    {
        Optional<Photo> photo = photoService.findById(idService, value);
        if(!photo.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(photo.get());
    }

    @PutMapping("/{id}/{value}")
    public ResponseEntity<Photo> update(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value, @Valid @RequestBody Photo photo)
    {
        if(!photoService.findById(idService, value).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(photoService.save(photo));
    }

    @DeleteMapping("/{id}/{value}")
    public ResponseEntity delete(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value)
    {

        if(!photoService.findById(idService, value).isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        photoService.deleteById(idService, value);

        return ResponseEntity.ok().build();
    }

}
