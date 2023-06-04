package me.don1ns.adsonlineresaleshop.repository;

import me.don1ns.adsonlineresaleshop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
