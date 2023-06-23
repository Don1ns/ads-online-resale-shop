package me.don1ns.adsonlineresaleshop.service.impl;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.repository.ImageRepository;
import me.don1ns.adsonlineresaleshop.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public String uploadImage(MultipartFile imageFile) {
        Image image = new Image();
        try {
            byte[] bytes = imageFile.getBytes();
            image.setImage(bytes);
        } catch (IOException e) {
            throw new RuntimeException("Проблемы с получением байтов");
        }
        image.setId(UUID.randomUUID().toString());
        imageRepository.save(image);
        Image savedImage = imageRepository.saveAndFlush(image);
        return savedImage.getId();
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
