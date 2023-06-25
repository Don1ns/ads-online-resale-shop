package me.don1ns.adsonlineresaleshop.service.impl;
import lombok.extern.slf4j.Slf4j;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.exception.ImageNotFoundException;
import me.don1ns.adsonlineresaleshop.repository.ImageRepository;
import me.don1ns.adsonlineresaleshop.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.UUID;

@Slf4j
@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    private final String path = System.getProperty("user.dir") + File.separator + "images";

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image uploadImage(MultipartFile imageFile) {
        Image image = new Image();
        try {
            String fileId = UUID.randomUUID() + Objects.requireNonNull(imageFile.getContentType()).replace("image/", ".");
            image.setId(fileId);

            Files.createDirectories(Paths.get(path));
            imageFile.transferTo(new File(path + File.separator + fileId));

            return image;
        } catch (IOException e) {
            throw new RuntimeException("Проблемы с получением байтов");
        }
    }

    @Override
    public byte[] loadImage(String filename) {
        File file;
        byte[] bytes;
        try {
            file = new File(path, filename);
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new ImageNotFoundException("Image not found");
        }
        return bytes;
    }

    @Override
    public Image getImageById(String id) {
        return imageRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Image with id " + id + " not found!"));
    }

    @Override
    public void remove(Image image) {
        imageRepository.delete(image);
    }

}
