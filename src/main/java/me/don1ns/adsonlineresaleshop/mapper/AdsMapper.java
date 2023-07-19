package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.AdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.FullAdsDTO;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

/**
 * @author Алексей Серебряков
 **/
@Mapper(componentModel = "spring")
public interface AdsMapper {
    @Mapping(source = "user.firstName", target = "authorFirstName")
    @Mapping(source = "user.lastName", target = "authorLastName")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phone", target = "phone")
    @Mapping(source = "image", target = "image", qualifiedByName = "imageMapper")
    @Mapping(source = "id", target = "pk")
    FullAdsDTO toFullAdsDto(Ads ads);

    @Mapping(source = "user.id", target = "authorId")
    @Mapping(source = "image", target = "image", qualifiedByName = "imageMapper")
    @Mapping(source = "id", target = "pk")
    AdsDTO toAdsDto(Ads ads);

    @Named("imageMapper")
    default String imageMapper(Image image) {
        if (image == null) {
            return null;
        }
        return "/ads/image/"+image.getId();
    }
}
