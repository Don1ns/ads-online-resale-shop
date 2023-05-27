package me.don1ns.adsonlineresaleshop.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * @author Loginova Viktoria (Логинова Виктория)
 **/
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AdsComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Ads ads;
    private LocalDateTime createdAt;
    private String text;
}
