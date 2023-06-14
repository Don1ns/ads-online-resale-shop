package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.DTO.*;
import me.don1ns.adsonlineresaleshop.entity.Image;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.exception.UserNotFoundException;
import me.don1ns.adsonlineresaleshop.mapper.UserMapper;
import me.don1ns.adsonlineresaleshop.repository.UserRepository;
import me.don1ns.adsonlineresaleshop.security.MyUserDetails;
import me.don1ns.adsonlineresaleshop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
     private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public void setPassword(NewPasswordDTO newPasswordDto, String userName) {
        User user = checkUserByUsername(userName);
        user.setPassword(newPasswordDto.getNewPassword());
        userRepository.save(user);
    }

    @Override
    public UserDTO getUser(String userName) {
        User user = userRepository.findByUsername(userName);
        if (user != null) {
            return userMapper.toDto(user);
        } else {
            return null;
        }
    }

    @Override
    public UserDTO updateUser(UserDTO userDto, String userName) {
        User user = checkUserByUsername(userName);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public User checkUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException(toString());
        }
        return user;
    }

    @Override
    public User updateUserImage(MultipartFile image, MyUserDetails currentUser) throws IOException {
        User user = userRepository.findByUsername(currentUser.getUsername());
        // Save the image to the server
        String fileName = image.getOriginalFilename();
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        String filePath = "path/to/image/directory/" + user.getId() + fileExtension; // Update the file path as per your server setup
        File file = new File(filePath);
        image.transferTo(file);

        // Update the user's image URL
        user.setImage((Image) image);
        userRepository.save(user);

        return user;
    }
}
