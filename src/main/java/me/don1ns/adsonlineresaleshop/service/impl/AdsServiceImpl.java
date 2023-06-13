package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.DTO.AdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperAds;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.exception.AdNotFoundException;
import me.don1ns.adsonlineresaleshop.mapper.AdsMapper;
import me.don1ns.adsonlineresaleshop.repository.AdsRepository;
import me.don1ns.adsonlineresaleshop.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsServiceImpl implements AdsService {
    private final AdsRepository repository;
    private final AdsMapper adsMapper;

    @Autowired
    public AdsServiceImpl(AdsRepository repository, AdsMapper adsMapper) {
        this.repository = repository;
        this.adsMapper = adsMapper;
    }

    @Override
    public void save(Ads ads) {
        repository.save(ads);
    }

    @Override
    public AdsDTO update(int id, CreateAdsDTO createAdsDTO) {
        Ads ads = repository.findById(id).orElseThrow(AdNotFoundException::new);
        ads.setDescription(createAdsDTO.getDescription());
        ads.setPrice(createAdsDTO.getPrice());
        ads.setTitle(createAdsDTO.getTitle());
        repository.save(ads);
        return adsMapper.toAdsDto(ads);
    }

    @Override
    public ResponseWrapperAds<Ads> getAllUserAds(String userName) {
        ResponseWrapperAds<Ads> response = new ResponseWrapperAds<>();
        List<Ads> list = repository.findAdsByUserName(userName);
        response.setCount(list.size());
        response.setResults(list);
        return response;
    }

    @Override
    public AdsDTO updateImage(int id, Image image) {
        Ads ads = repository.findById(id).orElseThrow(AdNotFoundException::new);
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
    public AdsDTO adAd(CreateAdsDTO createAdsDTO, Image image, User user) {
        Ads ads = adsMapper.toAds(createAdsDTO);
        ads.setImage(image);
        ads.setUser(user);
        repository.save(ads);
        return adsMapper.toAdsDto(ads);
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
        return adsMapper.toFullAdsDto(repository.findById(id).orElseThrow(AdNotFoundException::new));
    }

    @Override
    public ResponseWrapperAds<AdsDTO> getAllByTitle(String title) {
        ResponseWrapperAds<AdsDTO> response = new ResponseWrapperAds<>();
        List<AdsDTO> ads = repository.findAllByTitleContainingIgnoreCase(title).stream()
                .map(adsMapper::toAdsDto)
                .collect(Collectors.toList());
        response.setCount(ads.size());
        response.setResults(ads);
        return response;
    }
}
