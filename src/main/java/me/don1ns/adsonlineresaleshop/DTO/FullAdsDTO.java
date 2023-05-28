package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;

@Data
public class FullAdsDTO {
    private int pk;
    private String authorFirstName;
    private String authorLastName;
    private String description;
    private String email;
    private String image;
    private String phone;
    private int price;
    private String title;
}
