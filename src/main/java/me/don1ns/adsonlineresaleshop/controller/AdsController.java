package me.don1ns.adsonlineresaleshop.controller;

import me.don1ns.adsonlineresaleshop.DTO.AdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateAdsDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperAds;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    @GetMapping
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        return ResponseEntity.ok(new ResponseWrapperAds());
    }

    @PostMapping
    public ResponseEntity<AdsDTO> addAds(@RequestBody CreateAdsDTO createAds) {
        return ResponseEntity.ok(new AdsDTO());
    }

}