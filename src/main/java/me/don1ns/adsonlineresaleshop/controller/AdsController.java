package me.don1ns.adsonlineresaleshop.controller;

import me.don1ns.adsonlineresaleshop.DTO.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    // Получить все объявления

    @GetMapping("/")
    public ResponseEntity<ResponseWrapperAds> getAllAds() {
        return ResponseEntity.ok(new ResponseWrapperAds());
    }

    // Добавить объявление

    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdsDTO> addAds(@RequestParam CreateAdsDTO createAds, @RequestParam MultipartFile image) {
        return ResponseEntity.ok(new AdsDTO());
    }

    // Получить информацию об объявлении

    @GetMapping("/{id}")
    public ResponseEntity<FullAdsDTO> getAds(@PathVariable int id) {
        return ResponseEntity.ok(new FullAdsDTO());
    }

    // Удалить объявление

    @DeleteMapping("/{id}")
    public ResponseEntity<AdsDTO> removeAd(@PathVariable int id) {
        return ResponseEntity.ok().build();
    }

    // Обновить информацию об объявлении

    @PatchMapping("/{id}")
    public ResponseEntity<AdsDTO> updateAds(@PathVariable int id, @RequestBody CreateAdsDTO createAds) {
        return ResponseEntity.ok(new AdsDTO());
    }

    // Получить объявления авторизованного пользователя

    @GetMapping("/me")
    public ResponseEntity<ResponseWrapperAds> getAdsMe() {
        return ResponseEntity.ok(new ResponseWrapperAds());
    }

    // Обновить картинку объявления

    @PatchMapping("/{id}/image")
    public ResponseEntity<AdsDTO> updateImage(@PathVariable int id, @RequestParam MultipartFile image) {
        return ResponseEntity.ok(new AdsDTO());
    }

    // Получить комментарии объявления

    @GetMapping("{id}/comments")
    public ResponseEntity<ResponseWrapperCommentDTO> getComments(@PathVariable int id) {
        return ResponseEntity.ok(new ResponseWrapperCommentDTO());
    }

    // Добавить комментарий к объявлению

    @PostMapping("{id}/comments")
    public ResponseEntity<CreateCommentDTO> addComment(@PathVariable int id) {
        return ResponseEntity.ok(new CreateCommentDTO());
    }

    // Удалить комментарий

    @DeleteMapping("{adId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> deleteComment(@PathVariable int adId, @PathVariable int commentId) {
        return ResponseEntity.ok().build();
    }

    // Обновить комментарий

    @PatchMapping("{adId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable int adId, @PathVariable int commentId,
                                                    @RequestBody CommentDTO comment) {
        return ResponseEntity.ok(comment);
    }

}