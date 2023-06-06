package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;

public interface CommentService {
    void save(Integer id, Comment commentDto, User user);

    void update(Comment adsComment);

    void delete(Comment adsComment);
    void deleteById(int id);
    Comment getById(int id);
}
