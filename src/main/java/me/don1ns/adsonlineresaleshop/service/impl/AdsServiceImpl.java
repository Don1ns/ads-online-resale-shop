package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.exception.ErrorMessage;
import me.don1ns.adsonlineresaleshop.repository.AdsRepository;
import me.don1ns.adsonlineresaleshop.service.AdsService;

public class AdsServiceImpl implements AdsService {
    private final AdsRepository repository;

    public AdsServiceImpl(AdsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Ads ads) {
        repository.save(ads);
    }

    @Override
    public void update(Ads ads) {
        repository.save(ads);
    }

    @Override
    public void delete(Ads ads) {
        repository.delete(ads);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Ads getById(int id) {
        return repository.findById(id).orElseThrow(ErrorMessage::new);
    }
}
