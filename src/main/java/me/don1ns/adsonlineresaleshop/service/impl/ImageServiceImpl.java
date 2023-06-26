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

import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image uploadImage(MultipartFile imageFile) {
        Image image = new Image();
        try {
            String fileId = UUID.randomUUID().toString();
            image.setId(fileId);
            image.setBytes(imageFile.getBytes());
            return image;
        } catch (IOException e) {
            throw new RuntimeException("Проблемы с получением байтов");
        }
    }

    @Override
    public byte[] loadImage(String filename) {
        Image image = imageRepository.findById(filename).orElseThrow(ImageNotFoundException::new);
        return image.getBytes();
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
