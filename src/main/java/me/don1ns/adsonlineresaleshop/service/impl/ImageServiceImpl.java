package me.don1ns.adsonlineresaleshop.service.impl;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.repository.ImageRepository;
import me.don1ns.adsonlineresaleshop.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import java.io.IOException;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image uploadImage(MultipartFile imageFile) {
        Image image = new Image();
        try {
            byte[] bytes = imageFile.getBytes();
            image.setBytes(bytes);
            image.setSize(image.getSize());
            image.setOriginalFileName(imageFile.getOriginalFilename());
            image.setContentType(image.getContentType());
            image.setName(image.getName());
            Image savedImage = imageRepository.save(image);
            return savedImage;
        } catch (IOException e) {
            throw new RuntimeException("Проблемы с получением байтов");
        }
    }
    @Override
    public Image getImageById(int id) {
        return imageRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Image with id " + id + " not found!"));
    }

    @Override
    public void remove(Image image) {
        imageRepository.delete(image);
    }

}
