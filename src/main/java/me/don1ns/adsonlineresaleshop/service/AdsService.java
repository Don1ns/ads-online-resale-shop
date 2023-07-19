package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.AdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateAds;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperAds;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

public interface AdsService {
    void save(Ads ads);
    boolean deleteById(int id, Authentication authentication);
    Ads getById(int id);
    AdsDTO adAd(CreateAds createAds, MultipartFile file, Authentication authentication);
    ResponseWrapperAds<AdsDTO> getAllAds();
    FullAdsDTO getAdInfo(int id);
    ResponseWrapperAds<AdsDTO> getAllByTitle(String title);
    AdsDTO update(int id, CreateAds createAds, Authentication authentication);
    ResponseWrapperAds<AdsDTO> getAllUserAds(String userName);
    AdsDTO updateImage(int id, MultipartFile file, Authentication authentication);
}
