package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;
/**
 * @author Артем Королёв
 **/
@Data
public class AdsDTO {
    private long author;
    private String image;
    private long pk;
    private int price;
    private String title;
    private String description;
}

