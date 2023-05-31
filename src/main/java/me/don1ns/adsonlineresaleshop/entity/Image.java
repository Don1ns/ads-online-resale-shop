package me.don1ns.adsonlineresaleshop.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long size;
    private String mediaType;
    private byte[] image;
    @ManyToOne()
    @JoinColumn(name = "ads_id")
    private Ads ads;
}
