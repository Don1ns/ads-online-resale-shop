package me.don1ns.adsonlineresaleshop.repository;

import me.don1ns.adsonlineresaleshop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> getCommentsByAds_Id(int id);
}

