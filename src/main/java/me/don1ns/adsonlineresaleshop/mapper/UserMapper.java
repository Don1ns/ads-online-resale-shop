package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.UserDTO;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author Алексей Серебряков
 **/
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "image", target = "image.path")
    User toUser(UserDTO userDTO);
    @Mapping(source = "image.path", target = "image")
    UserDTO toDto(User user);
}
