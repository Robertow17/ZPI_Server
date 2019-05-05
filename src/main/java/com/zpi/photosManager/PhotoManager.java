package com.zpi.photosManager;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class PhotoManager {
    public static Optional<byte[]> getImage(int photoId, int serviceId) {
        File photo = new File(PhotoPathManager.getPathToSpecificPhoto(photoId, serviceId));

        if (!photo.exists()) {
            return Optional.empty();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(ImageIO.read(photo), "jpg", outputStream);
        } catch (IOException exception) {
            return Optional.empty();
        }

        return Optional.of(outputStream.toByteArray());
    }

    public static boolean saveImage(int photoId, int serviceId, byte[] photo) {
        try {
            RenderedImage image = ImageIO.read(new ByteArrayInputStream(photo));
            ImageIO.write(image, "jpg", new File(PhotoPathManager.getPathToSpecificPhoto(photoId, serviceId)));

            return true;
        } catch (IOException exception) {
            return false;
        }
    }

    public static boolean deleteImage(int photoId, int serviceId) {
        File photo = new File(PhotoPathManager.getPathToSpecificPhoto(photoId, serviceId));

        if (!photo.exists()) return false;

        try {
            Files.deleteIfExists(photo.toPath());

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