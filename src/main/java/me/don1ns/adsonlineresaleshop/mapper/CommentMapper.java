package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.CommentDTO;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Алексей Серебряков
 **/
@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(source = "pk", target = "id")
    @Mapping(target = "user.id", source = "author")
    @Mapping(target = "user.image.id", source = "authorImage")
    @Mapping(target = "user.firstName", source = "authorFirstName")
    Comment toAdsComment(CommentDTO commentDTO);

    @Mapping(source = "id", target = "pk")
    @Mapping(source = "user.id", target = "author")
    @Mapping(source = "user.image.id", target = "authorImage")
    @Mapping(source = "user.firstName", target = "authorFirstName")
    CommentDTO toCommentDto(Comment adsComment);

}
