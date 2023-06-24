package me.don1ns.adsonlineresaleshop.entity;

import javax.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

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
    private String id;
    @Lob
    private byte[] image;
    @ManyToOne()
    @JoinColumn(name = "ads_id")
    private Ads ads;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Image adsEntity = (Image) o;
        return id != null && Objects.equals(id, adsEntity.id);
    }
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
    public String getId() {
        return this.id;
    }
    public byte[] getImage() {
        return this.image;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public String toString() {
        return "AdsEntity(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getImage()) + ")";
    }
}
