package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.entity.Comment;

public interface CommentService {
    void save(Comment adsComment);

    void update(Comment adsComment);

    void delete(Comment adsComment);
    void deleteById(int id);
    Comment getById(int id);
}
