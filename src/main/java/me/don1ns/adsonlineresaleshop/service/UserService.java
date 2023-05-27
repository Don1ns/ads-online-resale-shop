package me.don1ns.adsonlineresaleshop.service;

import me.don1ns.adsonlineresaleshop.entity.User;

public interface UserService {
    void save(User user);

    void update(User user);

    void delete(User user);
    void deleteById(int id);
    User getById(int id);
}
