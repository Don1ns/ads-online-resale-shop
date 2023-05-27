package me.don1ns.adsonlineresaleshop.controller;

import me.don1ns.adsonlineresaleshop.DTO.LoginReqDTO;
import me.don1ns.adsonlineresaleshop.DTO.RegisterReqDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReqDTO req) {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterReqDTO req) {
        return ResponseEntity.ok().build();
    }
}
