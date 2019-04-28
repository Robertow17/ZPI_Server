package com.zpi.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/add")
    public ResponseEntity<PhotoDTO> create(@Valid @RequestBody PhotoDTO photoDTO)
    {
        photoService.save(PhotoMapper.INSTANCE.toPhoto(photoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(photoDTO);
    }


    @GetMapping("/all")
    public ResponseEntity<List<PhotoDTO>> getAll()
    {
        return ResponseEntity.ok(PhotoMapper.INSTANCE.toPhotoDTOs(photoService.findAll()));
    }

    @GetMapping("/{id}/{value}")
    public ResponseEntity<PhotoDTO> findById(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value)
    {
        Optional<Photo> photo = photoService.findById(idService, value);

        if(!photo.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(PhotoMapper.INSTANCE.toPhotoDTO(photo.get()));
    }

    @PutMapping("/{id}/{value}")
    public ResponseEntity<PhotoDTO> update(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value, @Valid @RequestBody PhotoDTO photoDTO)
    {
        Photo photo = PhotoMapper.INSTANCE.toPhoto(photoDTO);
        photo.setId(new PhotoPK(idService, value));
        photoService.save(photo);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(photoDTO);
    }

    @DeleteMapping("/{id}/{value}")
    public ResponseEntity delete(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value)
    {
        photoService.deleteById(idService, value);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
