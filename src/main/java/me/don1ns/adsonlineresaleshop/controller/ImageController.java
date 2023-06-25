package me.don1ns.adsonlineresaleshop.controller;

import me.don1ns.adsonlineresaleshop.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(value = "http://localhost:3000")
@RestController
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("images")
    public ResponseEntity<?>uploadImage(@RequestParam("file") MultipartFile file) {
        imageService.uploadImage(file);
        return ResponseEntity.ok().build();
    }
}
