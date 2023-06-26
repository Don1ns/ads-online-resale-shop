package me.don1ns.adsonlineresaleshop.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.don1ns.adsonlineresaleshop.DTO.*;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.exception.AdNotFoundException;
import me.don1ns.adsonlineresaleshop.exception.NoAccessException;
import me.don1ns.adsonlineresaleshop.mapper.AdsMapper;
import me.don1ns.adsonlineresaleshop.repository.AdsRepository;
import me.don1ns.adsonlineresaleshop.repository.CommentRepository;
import me.don1ns.adsonlineresaleshop.service.AdsService;
import me.don1ns.adsonlineresaleshop.service.CommentService;
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
    private final CommentRepository commentRepository;

    public AdsServiceImpl(AdsRepository repository, AdsMapper adsMapper, ImageService imageService, UserService userService, CommentRepository commentRepository) {
        this.repository = repository;
        this.adsMapper = adsMapper;
        this.imageService = imageService;
        this.userService = userService;
        this.commentRepository = commentRepository;
    }

    @Override
    public AdsDTO update(int id, CreateAds createAds, Authentication authentication) {
        if (adAccessCheck(id, authentication)) {
            Ads ads = repository.findById(id).orElseThrow(AdNotFoundException::new);
            ads.setDescription(createAds.getDescription());
            ads.setPrice(createAds.getPrice());
            ads.setTitle(createAds.getTitle());
            repository.save(ads);
            return adsMapper.toAdsDto(ads);
        }
        throw new NoAccessException("no access to ad");
    }


    @Override
    public AdsDTO updateImage(int id, MultipartFile file, Authentication authentication) {
        if (adAccessCheck(id, authentication)) {
            Ads ads = repository.findById(id).orElseThrow(AdNotFoundException::new);
            Image image = ads.getImage();
            if (image != null) {
                imageService.remove(image);
            }
            ads.setImage(imageService.uploadImage(file));
            return adsMapper.toAdsDto(repository.save(ads));
        }
        throw new NoAccessException("No access to ad");
    }


    @Override
    public void save(Ads ads) {
        repository.save(ads);
    }

    @Override
    public boolean deleteById(int id, Authentication authentication) {
        if (adAccessCheck(id, authentication)) {
            commentRepository.deleteAllByAds_Id(id);
            repository.deleteById(id);
            return true;
        }
        return false;
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
        ads.setImage(imageService.uploadImage(file));
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

    private boolean adAccessCheck(int id, Authentication authentication) {
        User user = userService.getUser(authentication.getName());
        if (user.getAuthorities().contains(Role.ADMIN)) {
            return true;
        }
        Ads ads = repository.getById(id);
        return ads.getUser().getId() == user.getId();
    }
}
