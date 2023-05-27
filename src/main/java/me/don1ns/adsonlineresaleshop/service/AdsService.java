package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.entity.Ads;

public interface AdsService {
    void save(Ads ads);

    void update(Ads ads);

    void delete(Ads ads);
    void deleteById(int id);
    Ads getById(int id);

}
