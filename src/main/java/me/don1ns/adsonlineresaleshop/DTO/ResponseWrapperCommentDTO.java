package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;

@Data
public class ResponseWrapperCommentDTO {
    private int count;
    private CommentDTO results;
}
