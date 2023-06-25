package me.don1ns.adsonlineresaleshop.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.don1ns.adsonlineresaleshop.DTO.AdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateAds;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperAds;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.exception.AdNotFoundException;
import me.don1ns.adsonlineresaleshop.mapper.AdsMapper;
import me.don1ns.adsonlineresaleshop.repository.AdsRepository;
import me.don1ns.adsonlineresaleshop.service.AdsService;
import me.don1ns.adsonlineresaleshop.service.ImageService;
import me.don1ns.adsonlineresaleshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class AdsServiceImpl implements AdsService {
    private final AdsRepository repository;
    private final AdsMapper adsMapper;
    private final ImageService imageService;
    private final UserService userService;

    @Autowired
    public AdsServiceImpl(AdsRepository repository, AdsMapper adsMapper, ImageService imageService, UserService userService) {
        this.repository = repository;
        this.adsMapper = adsMapper;
        this.imageService = imageService;
        this.userService = userService;
    }

    @Override
    public void save(Ads ads) {
        repository.save(ads);
    }

    @Override
    public AdsDTO update(int id, CreateAds createAds) {
        Ads ads = repository.findById(id).orElseThrow(AdNotFoundException::new);
        ads.setDescription(createAds.getDescription());
        ads.setPrice(createAds.getPrice());
        ads.setTitle(createAds.getTitle());
        repository.save(ads);
        return adsMapper.toAdsDto(ads);
    }




    @Override
    public AdsDTO updateImage(int id, MultipartFile file) {
        Ads ads = repository.findById(id).orElseThrow(AdNotFoundException::new);
        Image image = imageService.uploadImage(file);
        ads.setImage(image);
        repository.save(ads);
        return adsMapper.toAdsDto(ads);
    }



    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Ads getById(int id) {
        return repository.findById(id).orElseThrow(AdNotFoundException::new);
    }

    @Override
    public AdsDTO adAd(CreateAds createAds, MultipartFile file, Authentication authentication) {
        Ads ads = new Ads();
        ads.setDescription(createAds.getDescription());
        ads.setPrice(createAds.getPrice());
        ads.setTitle(createAds.getTitle());

        Image image = imageService.uploadImage(file);

        ads.setImage(image);

        ads.setUser(userService.getUser(authentication.getName()));

        repository.save(ads);
        return adsMapper.toAdsDto(ads);
    }

    @Override
    public ResponseWrapperAds<AdsDTO> getAllAds() {
        ResponseWrapperAds<AdsDTO> response = new ResponseWrapperAds<>();
        List<AdsDTO> list = repository.findAll().stream().map(adsMapper::toAdsDto).collect(Collectors.toList());
        response.setCount(list.size());
        response.setResults(list);
        return response;
    }

    @Override
    public ResponseWrapperAds<AdsDTO> getAllUserAds(String userName) {
        ResponseWrapperAds<AdsDTO> response = new ResponseWrapperAds<>();
        List<AdsDTO> list = repository.findAdsByUser_Email(userName).stream().map(adsMapper::toAdsDto).collect(Collectors.toList());
        response.setCount(list.size());
        response.setResults(list);
        return response;
    }

    @Override
    public FullAdsDTO getAdInfo(int id) {
        return adsMapper.toFullAdsDto(repository.findById(id).orElseThrow(AdNotFoundException::new));
    }
}
