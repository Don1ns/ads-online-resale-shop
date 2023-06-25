package me.don1ns.adsonlineresaleshop.repository;

import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ads, Integer> {
    List<Ads> findAdsByUser_Email(String email);
}
