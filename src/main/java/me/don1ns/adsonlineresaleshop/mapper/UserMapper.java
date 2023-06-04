package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.UserDTO;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Алексей Серебряков
 **/
@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserDTO userDTO);
    UserDTO toDto(User user);
}
