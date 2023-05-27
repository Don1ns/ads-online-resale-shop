package me.don1ns.adsonlineresaleshop.controller;

import me.don1ns.adsonlineresaleshop.DTO.*;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    // Обновление пароля

    @PostMapping("/set_password")
    public ResponseEntity<NewPasswordDTO> setPassword(@RequestBody NewPasswordDTO newPassword) {
        return ResponseEntity.ok().build();
    }

    // Получить информацию об авторизованном пользователе

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getUser() {
        return ResponseEntity.ok().build();
    }

    // Обновить информацию об авторизованном пользователе

    @PatchMapping("/me")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        return ResponseEntity.ok().build();
    }

    // Обновить аватар авторизованного пользователя

    @PatchMapping("/me/image")
    public ResponseEntity<UserDTO> updateUserImage(@RequestParam MultipartFile image) {
        return ResponseEntity.ok().build();
    }

}