package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;

import javax.persistence.Table;

/**
 * @author Артем Королёв
 **/
@Data
public class AdsDTO {
    private int authorId;
    private String image;
    private int pk;
    private int price;
    private String title;
    private String description;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

