package me.don1ns.adsonlineresaleshop.controller;
import lombok.RequiredArgsConstructor;
import me.don1ns.adsonlineresaleshop.DTO.NewPasswordDTO;
import me.don1ns.adsonlineresaleshop.DTO.UserDTO;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final User userDetails;

    // Обновление пароля
    @PostMapping("/set_password")
    public ResponseEntity<UserDTO> setPassword(@RequestBody NewPasswordDTO newPassword) {
        UserDTO userDTO = userService.setUserPassword(userDetails, newPassword);
        if (userDTO != null) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    // Получить информацию об авторизованном пользователе
    @GetMapping("/me")
    public ResponseEntity<User> getUser() {
        User user = userService.getUser(userDetails.getUsername());
        if (user != null) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    // Обновить информацию об авторизованном пользователе
    @PatchMapping("/me")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO) {
        User user = userService.updateUser(userDetails, userDTO);
        if (user != null) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    // Обновить аватар авторизованного пользователя
    @PatchMapping("/me/image")
    public ResponseEntity<UserDTO> updateUserImage(@RequestPart(name = "image") MultipartFile image) {
        UserDTO userDTO = userService.updateUserImage(userDetails, image);
        if (userDTO != null) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}