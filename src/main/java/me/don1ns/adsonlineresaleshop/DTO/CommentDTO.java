package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;

@Data
public class CommentDTO {
    private int author;
    private String authorImage;
    private String authorFirstName;
    private String createdAt;
    private long pk;
    private String text;
}
