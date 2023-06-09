package me.don1ns.adsonlineresaleshop.security;

import me.don1ns.adsonlineresaleshop.DTO.Role;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.security.access.AccessDeniedException;

public class SecurityUtils {
    public SecurityUtils() {
    }

    public static void checkPermissionToAds(Ads ads, User user) {
        MyUserDetails userDetails = new MyUserDetails(user);

        if (!userDetails.getAuthorities().contains(Role.ADMIN) && userDetails.getId() != ads.getUser().getId()) {
            throw new AccessDeniedException("Чтобы изменить/удалить объявление, нужно иметь роль ADMIN или быть владельцем этого объявления");
        }
    }

    public static void checkPermissionToAdsComment(Comment adsComment, User user) {
        MyUserDetails userDetails = new MyUserDetails(user);

        if (!userDetails.getAuthorities().contains(Role.ADMIN) && userDetails.getId() != adsComment.getUser().getId()) {
            throw new AccessDeniedException("Чтобы изменить/удалить комментарий, нужно иметь роль ADMIN или быть владельцем этого комментария");
        }
    }
}
