package me.don1ns.adsonlineresaleshop.security;

import lombok.Getter;
import me.don1ns.adsonlineresaleshop.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
@Getter
public class MyUserDetails extends org.springframework.security.core.userdetails.User{
    private final int id;

    public MyUserDetails(User user) {
        super(user.getEmail(), user.getPassword(), List.of((GrantedAuthority) user.getRole()));
        this.id = user.getId();
    }

    @Override
    public void eraseCredentials() {
    }
}
