package me.don1ns.adsonlineresaleshop.mappings;

import me.don1ns.adsonlineresaleshop.DTO.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Алексей Серебряков
 **/
@Mapper
public interface AdsComment {
    AdsComment INSTANCE = Mappers.getMapper(AdsComment.class);

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "user.image", target = "authorImage")
    @Mapping(source = "user.firstName", target = "authorFirstName")

    AdsComment toAdsComment(CommentDTO commentDTO);
    CommentDTO toCommentDto(AdsComment adsComment);
}
