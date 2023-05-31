package me.don1ns.adsonlineresaleshop.DTO;
import lombok.Data;
import java.util.Collection;

@Data
public class ResponseWrapperCommentDTO<T> {
    private int count;
    private Collection<T> results;
    public static <T> ResponseWrapperCommentDTO<T> of(Collection<T> results) {
        ResponseWrapperCommentDTO<T> responseWrapperCommentDTO = new ResponseWrapperCommentDTO<>();
        if (results == null) {
            return responseWrapperCommentDTO;
        }
        responseWrapperCommentDTO.results = results;
        responseWrapperCommentDTO.count = results.size();
        return responseWrapperCommentDTO;
    }
}
