package me.don1ns.adsonlineresaleshop.entity;

import jakarta.persistence.*;

/**
 * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;
    private Long size;
    private String path;
    private String mediaType;
    private byte[] data;
    @OneToOne
    private Ads ads;
}
