package me.don1ns.adsonlineresaleshop.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
  * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
@Data
@Table(name = "ads")
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String image;
    private int price;
    private String title;
    private String description;
    @ManyToOne
    private User user;
}
