package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.CreateAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Алексей Серебряков
 **/
@Mapper(componentModel = "spring")
public interface AdsMapper {
    @Mapping(source = "user.firstName", target = "authorFirstName")
    @Mapping(source = "user.lastName", target = "authorLastName")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phone", target = "phone")
    @Mapping(source = "image.path", target = "image")
    FullAdsDTO toFullAdsDto(Ads ads);

    @Mapping(source = "authorFirstName", target = "user.firstName")
    @Mapping(source = "authorLastName", target = "user.lastName")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "phone", target = "user.phone")
    @Mapping(source = "image", target = "image.path")
    Ads toAds(FullAdsDTO fullAdsDTO);
    Ads toAds(CreateAdsDTO createAdsDTO);


}
