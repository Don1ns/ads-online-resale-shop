package me.don1ns.adsonlineresaleshop.service.serviceImpl;

import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.repository.ImageRepository;
import me.don1ns.adsonlineresaleshop.service.ImageService;

public class ImageServiceImpl implements ImageService {
    private final ImageRepository repository;

    public ImageServiceImpl(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Image image) {
        repository.save(image);
    }

    @Override
    public void update(Image image) {
        repository.save(image);
    }

    @Override
    public void delete(Image image) {
        repository.delete(image);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Image getById(int id) {
        return repository.findById(id);
    }
}
