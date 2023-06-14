package me.don1ns.adsonlineresaleshop.controller;

import me.don1ns.adsonlineresaleshop.DTO.LoginReqDTO;
import me.don1ns.adsonlineresaleshop.DTO.RegisterReqDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
/*
@RestController
@CrossOrigin(value = "http://localhost:3000")
public class AuthController {

    @Operation(
            summary = "Авторизация пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Пользователь авторизован"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Пользователь не авторизован"
                    )
            },
            tags = "Авторизация"
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDTO req) {
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Регистрация пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Пользователь зарегистрирован"
                    )
            },
            tags = "Регистрация"
    )
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterReqDTO req) {
        return ResponseEntity.ok().build();
    }
}


 */