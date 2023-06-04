package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
/**
 * @author Алексей Серебряков
 **/
@Mapper(componentModel = "spring")
public interface AdsMapper {

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "user.firstName", target = "authorFirstName")
    @Mapping(source = "user.lastName", target = "authorLastName")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phone", target = "phone")

    FullAdsDTO toFullAdsDto(Ads ads);
    Ads toAds(FullAdsDTO fullAdsDTO);
}
