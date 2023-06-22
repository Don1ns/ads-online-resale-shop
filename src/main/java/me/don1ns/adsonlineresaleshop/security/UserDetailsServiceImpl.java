package me.don1ns.adsonlineresaleshop.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.don1ns.adsonlineresaleshop.DTO.RegisterReqDTO;
import me.don1ns.adsonlineresaleshop.DTO.Role;
import me.don1ns.adsonlineresaleshop.entity.User;
import me.don1ns.adsonlineresaleshop.repository.UserRepository;
import org.springframework.security.acls.model.AlreadyExistsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailsServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username).orElseThrow();
        return new MyUserDetails(user);
    }

    public void createUser(RegisterReqDTO registerReqDTO) {
        if (userRepository.existsByEmailIgnoreCase(registerReqDTO.getUsername())) {
            throw new AlreadyExistsException("User already exist");
        }
        User user = new User();
        user.setFirstName(registerReqDTO.getFirstName());
        user.setLastName(registerReqDTO.getLastName());
        user.setEmail(registerReqDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerReqDTO.getPassword()));
        user.setPhone(registerReqDTO.getPhone());
        user.setRole(Role.USER);

        userRepository.save(user);
    }
}
