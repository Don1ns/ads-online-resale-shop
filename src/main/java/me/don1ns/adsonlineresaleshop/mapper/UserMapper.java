package me.don1ns.adsonlineresaleshop.mapper;

import me.don1ns.adsonlineresaleshop.DTO.RegisterReqDTO;
import me.don1ns.adsonlineresaleshop.DTO.UserDTO;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Алексей Серебряков
 **/
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "image", target = "image.id")
    User toUser(UserDTO userDTO);
    @Mapping(source = "image.id", target = "image")
    UserDTO toDto(User user);

    //Маперы для регистрации
    @Mapping(target = "role", defaultValue = "USER")
    @Mapping(source = "username", target = "email")
    User toEntity(RegisterReqDTO dto);
}
