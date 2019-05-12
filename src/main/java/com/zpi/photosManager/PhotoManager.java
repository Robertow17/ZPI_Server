package com.zpi.photosManager;

import com.zpi.photo.PhotoDTO;
import com.zpi.photo.PhotoMapper;
import com.zpi.photo.PhotoService;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.swing.text.html.Option;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

public class PhotoManager {
    public static Optional<byte[]> getImage(int photoId, int serviceId) {
        File photo = new File(PhotoPathManager.getPathToSpecificPhoto(photoId, serviceId));

        if (!photo.exists()) {
            return Optional.empty();
        }

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ImageIO.write(ImageIO.read(photo), "jpg", outputStream);
            return Optional.of(outputStream.toByteArray());
        } catch (IOException exception) {
            return Optional.empty();
        }
    }

    public static Optional<Integer> saveImage(int serviceId, MultipartFile photo, PhotoService photoService) {
        try {
            int photoId = saveImageToDB(serviceId, photoService);
            RenderedImage image = ImageIO.read(new ByteArrayInputStream(photo.getBytes()));
            ImageIO.write(image, "jpg", new File(PhotoPathManager.getPathToSpecificPhoto(photoId, serviceId)));

            return Optional.of(photoId);
        } catch (IOException exception) {
            exception.printStackTrace();
            return Optional.empty();
        }
    }

    private static int saveImageToDB(int serviceId, PhotoService photoService) {
        PhotoDTO photoDTO = new PhotoDTO();
        photoDTO.setIdService(serviceId);
        return photoService.save(PhotoMapper.INSTANCE.toPhoto(photoDTO)).getId();
    }

    public static boolean deleteImage(int photoId, int serviceId, PhotoService photoService) {
        File photo = new File(PhotoPathManager.getPathToSpecificPhoto(photoId, serviceId));

        if (!photo.exists()) return false;

        try {
            photoService.deleteById(photoId);
            Files.delete(photo.toPath());

            return true;
        } catch (Exception exception) {
            return false;
        }
    }
}

class PhotoPathManager {
    // TODO: change path on real server
    private static final String resourcePath = "/Users/wko/University/Semestr VI/ZPI/zpi_server/src/main/resources/photos/";

    /**
     * Photo file naming convention: service{serviceId}.photo{photoId}.jpg
     */
    private static String getPhotoFilename(int photoId, int serviceId) {
        return "service" + serviceId + ".photo" + photoId;
    }

    static String getPathToSpecificPhoto(int photoId, int serviceId) {
        return resourcePath + getPhotoFilename(photoId, serviceId) + ".jpg";
    }
}