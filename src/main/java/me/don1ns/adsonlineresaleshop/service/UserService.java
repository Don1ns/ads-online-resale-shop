package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.*;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    void createUser(User user);

    boolean setPassword(NewPasswordDTO newPasswordDto, String userName);

    User getUserById(int id);
    User getUser(String userName);

    UserDTO getUser(Authentication authentication);

    UserDTO updateUser(UserDTO userDto, String userName);
    User checkUserByUsername(String username);
    User updateUserImage(MultipartFile image, User currentUser) throws IOException;
}


