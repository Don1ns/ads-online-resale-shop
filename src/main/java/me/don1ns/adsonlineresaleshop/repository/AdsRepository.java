package me.don1ns.adsonlineresaleshop.repository;

import me.don1ns.adsonlineresaleshop.entity.Ads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdsRepository extends JpaRepository<Ads, Integer> {
    @Query(value = "select * from ads where user.username = :user_name", nativeQuery = true)
    List<Ads> findAdsByUserName(@Param("user_name") String userName);
    List<Ads> findAllByTitleContainingIgnoreCase(String title);
    List<Ads> findAdsByUser_Email(String email);
}
