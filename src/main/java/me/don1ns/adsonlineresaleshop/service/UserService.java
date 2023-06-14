package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.*;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.security.MyUserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    void setPassword(NewPasswordDTO newPasswordDto, String userName);
    UserDTO getUser(String userName);
    UserDTO updateUser(UserDTO userDto, String userName);
    User checkUserByUsername(String username);
    User updateUserImage(MultipartFile image, MyUserDetails currentUser) throws IOException;
}


