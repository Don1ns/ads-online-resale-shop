package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;
/**
 * @author Артем Королёв
 **/
@Data
public class CreateAds {
    private String description;
    private int price;
    private String title;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
