package com.example.issuecrudservice.services.impl;

import com.example.issuecrudservice.dto.LoginUserDto;
import com.example.issuecrudservice.dto.RegisterUserDto;
import com.example.issuecrudservice.entities.UserEntity;
import com.example.issuecrudservice.repositories.UserRepository;
import com.example.issuecrudservice.services.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    @Override
    public UserEntity signup(RegisterUserDto input) {
        UserEntity user = UserEntity.builder().
                email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .createdAt(new Date())
                .build();

        userRepository.save(user);
        return user;
    }

    @Override
    public UserEntity authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
