package me.don1ns.adsonlineresaleshop.service.impl;

import javax.xml.bind.ValidationException;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.don1ns.adsonlineresaleshop.DTO.RegisterReqDTO;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.mapper.UserMapper;
import me.don1ns.adsonlineresaleshop.repository.UserRepository;
import me.don1ns.adsonlineresaleshop.security.UserDetailsServiceImpl;
import me.don1ns.adsonlineresaleshop.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthenticationServiceImpl(UserDetailsServiceImpl userDetailsServiceImpl, PasswordEncoder encoder, UserRepository userRepository, UserMapper userMapper) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(String userName, String password) {
        try {
            UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(userName);
            String encryptedPassword = userDetails.getPassword();
            if (!encoder.matches(password, encryptedPassword)) {
                throw new BadCredentialsException("Wrong password!");
            }
            return true;
        } catch (UsernameNotFoundException e) {
            throw new BadCredentialsException(String.format("User \"%s\" does not exist!", userName));
        } catch (IllegalArgumentException e) {
            throw new BadCredentialsException("Bad credentials!");
        }
    }

    @Override
    public boolean register(RegisterReqDTO registerReqDTO) {
        User user = userMapper.toEntity(registerReqDTO);
        if (userRepository.existsByEmailIgnoreCase(user.getEmail())) {
            throw new RuntimeException("user already exist");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
