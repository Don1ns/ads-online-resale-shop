package me.don1ns.adsonlineresaleshop.repository;

import me.don1ns.adsonlineresaleshop.entity.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ads, Integer> {
    List<Ads> findAdsByUser_Email(String email);
}
