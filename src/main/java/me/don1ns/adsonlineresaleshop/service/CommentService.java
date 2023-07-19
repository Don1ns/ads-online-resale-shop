package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.CommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateCommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.ResponseWrapperCommentDTO;
import org.springframework.security.core.Authentication;

public interface CommentService {


    ResponseWrapperCommentDTO getComments(Integer id);

    CommentDTO addComment(Integer id, CreateCommentDTO createCommentDTO, Authentication authentication);

    CommentDTO updateComment(Integer adId, Integer commentId, CommentDTO commentDTO, Authentication authentication);

    boolean deleteComment(Integer adId,Integer commentId, Authentication authentication);

    void deleteAllByAdsId(int id);


}
