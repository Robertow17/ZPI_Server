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
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    @PostMapping("/add")
    public ResponseEntity<PhotoDTO> create(@Valid @RequestBody PhotoDTO photoDTO) {
        photoService.save(PhotoMapper.INSTANCE.toPhoto(photoDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(photoDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PhotoDTO>> getAll() {
        return ResponseEntity.ok(PhotoMapper.INSTANCE.toPhotoDTOs(photoService.findAll()));
    }

    @GetMapping("/{id}/{value}")
    public ResponseEntity<PhotoDTO> findById(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value) {
        Optional<Photo> photo = photoService.findById(idService, value);

        if (!photo.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(PhotoMapper.INSTANCE.toPhotoDTO(photo.get()));
    }

    @PutMapping("/update/{id}/{value}")
    public ResponseEntity<PhotoDTO> update(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value, @Valid @RequestBody PhotoDTO photoDTO) {
        Photo photo = PhotoMapper.INSTANCE.toPhoto(photoDTO);
        photo.setId(new PhotoPK(idService, value));
        photoService.save(photo);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(photoDTO);
    }

    @DeleteMapping("/delete/{id}/{value}")
    public ResponseEntity delete(@PathVariable(value = "id") int idService, @PathVariable(value = "value") String value) {
        photoService.deleteById(idService, value);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping(value = "/experiment/{serviceId}")
    public ResponseEntity<String> createPhoto(@RequestParam("photo") MultipartFile photo, @PathVariable int serviceId) {
        try {
            byte[] file = photo.getBytes();
            boolean isImageSaved = PhotoManager.saveImage(150, serviceId, file);

            return ResponseEntity.status(HttpStatus.CREATED).body(String.valueOf(isImageSaved));
        } catch (IOException exception) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping(value = "/experiment/{serviceId}/{photoId}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable int serviceId, @PathVariable int photoId) {
        Optional<byte[]> responsePhoto = PhotoManager.getImage(photoId, serviceId);

        return responsePhoto.map(bytes -> ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/experiment/{serviceId}/{photoId}")
    public ResponseEntity<byte[]> deletePhoto(@PathVariable int serviceId, @PathVariable int photoId) {
        boolean isPhotoDeleted = PhotoManager.deleteImage(photoId, serviceId);

        return ResponseEntity.status(isPhotoDeleted ? HttpStatus.OK : HttpStatus.BAD_REQUEST).build();
    }
}
