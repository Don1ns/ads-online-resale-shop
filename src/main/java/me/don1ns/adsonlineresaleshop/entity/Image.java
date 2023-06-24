package me.don1ns.adsonlineresaleshop.entity;

import javax.persistence.*;
import lombok.*;

/**
 * @author Loginova Viktoria (Логинова Виктория)
 **/
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Lob
    private byte[] bytes;
    private String originalFileName;
    private long size;
    private String contentType;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Ads ads;
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }

    public byte[] getBytes() {
        return this.bytes;
    }
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }
    public String toString() {
        return "AdsEntity(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getBytes()) + ")";
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
