package me.don1ns.adsonlineresaleshop.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
  * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
@Data
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private int price;
    private String title;
    private String contentType;
    private String description;
    @ManyToOne
    private User user;
}
