package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.CreateAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperAds;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Image;

public interface AdsService {
    void save(Ads ads);
    void deleteById(int id);
    Ads getById(int id);
    Ads addAd(CreateAdsDTO createAdsDTO, Image image);
    ResponseWrapperAds<Ads> getAllAds();
    FullAdsDTO getAdInfo(int id);
    void delete(Ads ads);
    Ads update(int id, CreateAdsDTO createAdsDTO);
    ResponseWrapperAds<Ads> getAllUserAds();
    void updateImage(int id, Image image);
}
