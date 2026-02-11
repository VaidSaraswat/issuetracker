package com.example.issuecrudservice.services.impl;

import com.example.issuecrudservice.entities.UserEntity;
import com.example.issuecrudservice.repositories.UserRepository;
import com.example.issuecrudservice.services.UserService;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository boardRepository) {
        this.userRepository = boardRepository;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
