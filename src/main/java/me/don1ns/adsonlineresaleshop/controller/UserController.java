package me.don1ns.adsonlineresaleshop.controller;
import me.don1ns.adsonlineresaleshop.DTO.NewPasswordDTO;
import me.don1ns.adsonlineresaleshop.DTO.UserDTO;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Обновление пароля
    @PostMapping("/set_password")
    public ResponseEntity<UserDTO> setPassword(@RequestBody NewPasswordDTO newPassword,  Authentication authentication) {
        User user = userService.checkUserByUsername(authentication.getName());
        if (user != null) {
            userService.setPassword(newPassword, authentication.getName());
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    // Получить информацию об авторизованном пользователе
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getUser(Authentication authentication) {
        printLogInfo("me", "get", "/me");
        UserDTO user = userService.getUser(authentication);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    // Обновить информацию об авторизованном пользователе
    @PatchMapping("/me")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, Authentication authentication) {
        UserDTO user = userService.updateUser(userDTO, authentication.getName());
        if (user != null) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    /*
    // Обновить аватар авторизованного пользователя
    @PatchMapping("/me/image")
    public ResponseEntity<UserDTO> updateUserImage(@RequestPart(name = "image") MultipartFile image, Authentication authentication) {
        UserDTO userDTO = userService.updateUserImage(authentication.getName(), image);
        if (userDTO != null) {
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

     */

    private void printLogInfo(String name, String requestMethod, String path) {
        logger.info("Вызван метод " + name + ", адрес "
                + requestMethod.toUpperCase() + " запроса " + path);
    }
}