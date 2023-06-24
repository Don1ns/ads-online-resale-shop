package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.AdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperAds;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

public interface AdsService {
    void save(Ads ads);
    void deleteById(int id);
    Ads getById(int id);
    AdsDTO adAd(CreateAdsDTO createAdsDTO, MultipartFile file, Authentication authentication);
    ResponseWrapperAds<Ads> getAllAds();
    FullAdsDTO getAdInfo(int id);
    AdsDTO update(int id, CreateAdsDTO createAdsDTO);
    ResponseWrapperAds<Ads> getAllUserAds(String userName);
    AdsDTO updateImage(int id, MultipartFile file);
}
