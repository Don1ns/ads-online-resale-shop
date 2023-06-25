package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.entity.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    Image uploadImage(MultipartFile imageFile);

    byte[] loadImage(String id);

    Image getImageById(String id);

    void remove(Image image);
}
