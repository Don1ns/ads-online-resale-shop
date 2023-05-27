package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.entity.Image;

public interface ImageService {
    void save(Image image);

    void update(Image image);

    void delete(Image image);
    void deleteById(long id);
    Image getById(long id);
}
