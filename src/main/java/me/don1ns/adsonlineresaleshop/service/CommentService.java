package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.CommentDTO;
import me.don1ns.adsonlineresaleshop.DTO.CreateCommentDTO;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface CommentService {


    CommentDTO addComment(Integer id, Comment commentDto, User user);

    CommentDTO updateComment(Integer adId, Integer commentId, CommentDTO commentDTO, UserDetails currentUser);

    boolean deleteComment(Integer commentId, UserDetails currentUser);


}
