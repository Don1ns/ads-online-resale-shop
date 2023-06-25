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
@Table(name = "image")
public class Image {
    @Id
    private String id;
    private String name;
    @Lob
    private byte[] image;
    private String originalFileName;
    private long size;
    private String contentType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String toString() {
        return "AdsEntity(id=" + this.getId() + ", image=" + java.util.Arrays.toString(this.getImage()) + ")";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Image image = (Image) o;
        return id != null && Objects.equals(id, image.id);
    }
}
