package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.AdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateAds;
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
    @Mapping(source = "image.id", target = "image")
    @Mapping(source = "id", target = "pk")
    FullAdsDTO toFullAdsDto(Ads ads);

    @Mapping(source = "user.id", target = "authorId")
    @Mapping(source = "image.id", target = "image")
    @Mapping(source = "id", target = "pk")
    AdsDTO toAdsDto(Ads ads);

    @Mapping(source = "authorFirstName", target = "user.firstName")
    @Mapping(source = "authorLastName", target = "user.lastName")
    @Mapping(source = "email", target = "user.email")
    @Mapping(source = "phone", target = "user.phone")
    @Mapping(source = "image", target = "image.id")
    @Mapping(source = "pk", target = "id")
    Ads toAds(FullAdsDTO fullAdsDTO);
    Ads toAds(CreateAds createAds);


}
