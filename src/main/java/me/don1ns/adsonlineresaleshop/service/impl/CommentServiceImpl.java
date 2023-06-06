package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.exception.ErrorMessage;
import me.don1ns.adsonlineresaleshop.repository.CommentRepository;
import me.don1ns.adsonlineresaleshop.service.AdsService;
import me.don1ns.adsonlineresaleshop.service.CommentService;
import me.don1ns.adsonlineresaleshop.mapper.CommentMapper;
import me.don1ns.adsonlineresaleshop.service.UserService;

import java.time.LocalDateTime;

public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final AdsService adsService;
    private final CommentMapper commentMapper;
    private final UserService userService;

    public CommentServiceImpl(CommentRepository commentRepository, AdsService adsService, CommentMapper commentMapper, UserService userService) {
        this.commentRepository = commentRepository;
        this.adsService = adsService;
        this.commentMapper = commentMapper;
        this.userService = userService;
    }

    @Override
    public void save(Integer id, Comment commentDto, User user) {
        Comment comment = new Comment();
        comment.setId(id);
        comment.setUser(user);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setText(commentDto.getText());

        comment = commentRepository.save(comment);
    }

    @Override
    public void update(Comment adsComment) {
        commentRepository.save(adsComment);
    }

    @Override
    public void delete(Comment adsComment) {
        commentRepository.delete(adsComment);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public Comment getById(int id) {
        return commentRepository.findById(id).orElseThrow(ErrorMessage::new);
    }
}
