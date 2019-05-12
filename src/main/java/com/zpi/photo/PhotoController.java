package com.zpi.photo;

import com.zpi.photosManager.PhotoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path = "/photos")
public class PhotoController
{

    @Autowired
    private PhotoService photoService;

    @PostMapping("/add")
    public ResponseEntity<Photo> create(@Valid @RequestBody PhotoDTO photoDTO)
    {
        Photo photo = photoService.save(PhotoMapper.INSTANCE.toPhoto(photoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(photo);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Photo>> getAll()
    {
        return ResponseEntity.ok(photoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Photo> findById(@PathVariable(value = "id") int id)
    {
        Optional<Photo> photo = photoService.findById(id);

        if(!photo.isPresent())
        {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(photo.get());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Photo> update(@PathVariable(value = "id") int id, @Valid @RequestBody PhotoDTO photoDTO)
    {
        Photo photo = PhotoMapper.INSTANCE.toPhoto(photoDTO);
        photo.setId(id);
        photoService.save(photo);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(photo);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id)
    {
        photoService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping(value = "/experiment/{serviceId}")
    public ResponseEntity<Integer> createPhoto(@RequestParam("photo") MultipartFile photo, @PathVariable int serviceId) {
        Optional<Integer> photoId = PhotoManager.saveImage(serviceId, photo, photoService);
        return photoId.isPresent()
                ? ResponseEntity.status(HttpStatus.CREATED).body(photoId.get())
                : ResponseEntity.unprocessableEntity().build();
    }

    @GetMapping(value = "/experiment/{serviceId}/{photoId}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable int serviceId, @PathVariable int photoId) {
        Optional<byte[]> responsePhoto = PhotoManager.getImage(photoId, serviceId);

        return responsePhoto.isPresent()
                ? ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(responsePhoto.get())
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/experiment/{serviceId}/{photoId}")
    public ResponseEntity<byte[]> deletePhoto(@PathVariable int serviceId, @PathVariable int photoId) {
        boolean isPhotoDeleted = PhotoManager.deleteImage(photoId, serviceId, photoService);

        return ResponseEntity.status(isPhotoDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND).build();
    }
}
