package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;
/**
 * @author Артем Королёв
 **/
@Data
public class CommentDTO {
    private int author;
    private String authorImage;
    private String authorFirstName;
    private long createdAt;
    private long pk;
    private String text;
}
