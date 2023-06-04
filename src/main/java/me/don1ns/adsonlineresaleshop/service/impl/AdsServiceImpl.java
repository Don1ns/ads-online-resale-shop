package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.DTO.CreateAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperAds;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.exception.ErrorMessage;
import me.don1ns.adsonlineresaleshop.mapper.AdsMapper;
import me.don1ns.adsonlineresaleshop.repository.AdsRepository;
import me.don1ns.adsonlineresaleshop.service.AdsService;

import java.util.List;

public class AdsServiceImpl implements AdsService {
    private final AdsRepository repository;
    private final AdsMapper adsMapper;

    public AdsServiceImpl(AdsRepository repository, AdsMapper adsMapper) {
        this.repository = repository;
        this.adsMapper = adsMapper;
    }

    @Override
    public void save(Ads ads) {
        repository.save(ads);
    }

    @Override
    public Ads update(int id, CreateAdsDTO createAdsDTO) {
        Ads ads = repository.findById(id).orElseThrow();
        ads.setDescription(createAdsDTO.getDescription());
        ads.setPrice(createAdsDTO.getPrice());
        ads.setTitle(createAdsDTO.getTitle());
        repository.save(ads);
        return ads;
    }

    @Override
    public ResponseWrapperAds<Ads> getAllUserAds() {
        ResponseWrapperAds<Ads> response = new ResponseWrapperAds<>();
        List<Ads> list = repository.findAll();
        response.setCount(list.size());
        response.setResults(list);
        return response;
    }

    @Override
    public void updateImage(int id, Image image) {

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

    @Override
    public Ads addAd(CreateAdsDTO createAdsDTO, Image image) {
        Ads ads = adsMapper.toAds(createAdsDTO);
        ads.setImage(image);
        repository.save(ads);
        return ads;
    }

    @Override
    public ResponseWrapperAds<Ads> getAllAds() {
        ResponseWrapperAds<Ads> response = new ResponseWrapperAds<>();
        List<Ads> list = repository.findAll();
        response.setCount(list.size());
        response.setResults(list);
        return response;
    }

    @Override
    public FullAdsDTO getAdInfo(int id) {
        return adsMapper.toFullAdsDto(repository.findById(id).orElseThrow(ErrorMessage::new));
    }
}
