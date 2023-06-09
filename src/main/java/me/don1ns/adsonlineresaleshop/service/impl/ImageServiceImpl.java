package me.don1ns.adsonlineresaleshop.service.impl;
import lombok.RequiredArgsConstructor;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.repository.ImageRepository;
import me.don1ns.adsonlineresaleshop.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.webjars.NotFoundException;
import java.io.IOException;

@Transactional
@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Override
    public Image uploadImage(MultipartFile imageFile) throws IOException {
        Image image = new Image();
        image.setImage(imageFile.getBytes());
        image.setSize(imageFile.getSize());
        image.setMediaType(imageFile.getContentType());
        return imageRepository.save(image);
    }
    @Override
    public Image getImageById(long id) {
        return imageRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Image with id " + id + " not found!"));
    }

    @Override
    public void remove(Image image) {
        imageRepository.delete(image);
    }

}
