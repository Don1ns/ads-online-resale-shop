package me.don1ns.adsonlineresaleshop.service.impl;

import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.exception.ErrorMessage;
import me.don1ns.adsonlineresaleshop.repository.UserRepository;
import me.don1ns.adsonlineresaleshop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return repository.findById(id).orElseThrow(ErrorMessage::new);
    }
}
