package me.don1ns.adsonlineresaleshop.entity;

import javax.persistence.*;
import lombok.*;

/**
 * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
@Data
@Table(name = "image")
public class Image {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
