package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.DTO.CreateCommentDTO;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface CommentService {


    void addComment(Integer id, Comment commentDto, User user);

    Comment updateComment(int id, CreateCommentDTO createCommentDTO);

    boolean deleteComment(Integer adId, Integer commentId, UserDetails currentUser);


}
