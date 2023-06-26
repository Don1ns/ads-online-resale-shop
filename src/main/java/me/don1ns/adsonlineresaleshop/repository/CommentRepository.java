package me.don1ns.adsonlineresaleshop.repository;

import me.don1ns.adsonlineresaleshop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> getCommentsByAds_Id(int id);

    void deleteAllByAds_Id(int id);

    Optional<Comment> findById(int integer);
}

