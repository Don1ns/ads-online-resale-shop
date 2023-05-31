package me.don1ns.adsonlineresaleshop.service.serviceImpl;

import me.don1ns.adsonlineresaleshop.entity.AdsComment;
import me.don1ns.adsonlineresaleshop.exception.ErrorMessage;
import me.don1ns.adsonlineresaleshop.repository.AdsCommentRepository;
import me.don1ns.adsonlineresaleshop.service.AdsCommentService;

public class AdsCommentServiceImpl implements AdsCommentService {
    private final AdsCommentRepository repository;

    public AdsCommentServiceImpl(AdsCommentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(AdsComment adsComment) {
        repository.save(adsComment);
    }

    @Override
    public void update(AdsComment adsComment) {
        repository.save(adsComment);
    }

    @Override
    public void delete(AdsComment adsComment) {
        repository.delete(adsComment);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public AdsComment getById(int id) {
        return repository.findById(id).orElseThrow(ErrorMessage::new);
    }
}
