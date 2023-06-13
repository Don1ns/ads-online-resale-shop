package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.*;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.security.MyUserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    UserDTO setPassword(NewPasswordDTO newPasswordDto, MyUserDetails currentUser);
    UserDTO getUser(MyUserDetails currentUser);
    boolean updateUser(User userDto, MyUserDetails currentUser);
    User checkUserByUsername(String username);
    User updateUserImage(MultipartFile image, MyUserDetails currentUser) throws IOException;
}


