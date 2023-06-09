package me.don1ns.adsonlineresaleshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
  * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
@Data
@Table(name = "ads")
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "img_id")
    private Image image;
    private int price;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
