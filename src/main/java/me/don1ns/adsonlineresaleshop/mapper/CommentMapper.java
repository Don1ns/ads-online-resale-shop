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
    @Mapping(target = "user.imageId", source = "authorImage")
    @Mapping(target = "user.firstName", source = "authorFirstName")
    Comment toAdsComment(CommentDTO commentDTO);
    CommentDTO toCommentDto(Comment adsComment);

}
