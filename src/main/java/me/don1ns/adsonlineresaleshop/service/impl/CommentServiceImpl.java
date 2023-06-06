package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.exception.ErrorMessage;
import me.don1ns.adsonlineresaleshop.repository.CommentRepository;
import me.don1ns.adsonlineresaleshop.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;

    public CommentServiceImpl(CommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Comment adsComment) {
        repository.save(adsComment);
    }

    @Override
    public void update(Comment adsComment) {
        repository.save(adsComment);
    }

    @Override
    public void delete(Comment adsComment) {
        repository.delete(adsComment);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public Comment getById(int id) {
        return repository.findById(id).orElseThrow(ErrorMessage::new);
    }
}
