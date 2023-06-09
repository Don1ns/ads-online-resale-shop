package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.*;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.entity.User;

public interface UserService {
    void createUser (RegisterReqDTO registerReqDto, Role role);
    UserDTO setUserPassword(User authUser, NewPasswordDTO newPasswordDto);
    User getUser(String username);
    User updateUser(User authUser, UserDTO userDto);
    UserDTO updateUserImage(User authUser, Image image);
    UserDTO getCurrentUser(LoginReqDTO loginReqDTO);


   /* void save(User user);
    void update(User user);
    void delete(User user);
    void deleteById(int id);
    User getById(int id);*/
}
