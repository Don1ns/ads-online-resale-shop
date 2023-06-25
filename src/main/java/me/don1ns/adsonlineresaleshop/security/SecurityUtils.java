package me.don1ns.adsonlineresaleshop.security;

import me.don1ns.adsonlineresaleshop.DTO.Role;
import me.don1ns.adsonlineresaleshop.entity.Ads;
import me.don1ns.adsonlineresaleshop.entity.Comment;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtils {
    public SecurityUtils() {
    }

    public static void checkPermissionToAds(Ads ads, User user) {
        if (!user.getAuthorities().contains(Role.ADMIN) && user.getId() != ads.getUser().getId()) {
            throw new AccessDeniedException("Чтобы изменить/удалить объявление, нужно иметь роль ADMIN или быть владельцем этого объявления");
        }
    }

    public static void checkPermissionToAdsComment(Comment adsComment, User user) {
        if (!user.getAuthorities().contains(Role.ADMIN) && user.getId() != adsComment.getUser().getId()) {
            throw new AccessDeniedException("Чтобы изменить/удалить комментарий, нужно иметь роль ADMIN или быть владельцем этого комментария");
        }
    }
}
