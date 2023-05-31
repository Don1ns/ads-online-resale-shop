package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;
/**
 * @author Артем Королёв
 **/
@Data
public class CreateAdsDTO {
    private String description;
    private int price;
    private String title;
}
