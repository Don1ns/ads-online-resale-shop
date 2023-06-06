package me.don1ns.adsonlineresaleshop.service.impl;

import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import me.don1ns.adsonlineresaleshop.DTO.RegisterReqDTO;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.mapper.UserMapper;
import me.don1ns.adsonlineresaleshop.repository.UserRepository;
import me.don1ns.adsonlineresaleshop.security.UserDetailsServiceImpl;
import me.don1ns.adsonlineresaleshop.service.AuthenticationService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

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
            throw new ValidationException(String.format("User \"%s\" is already registered!", user.getEmail()));
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRegDate(Instant.now());
        userRepository.save(user);
        return true;
    }
}
