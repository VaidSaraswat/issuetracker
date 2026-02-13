package com.example.issuecrudservice.services;

import com.example.issuecrudservice.entities.UserEntity;

public interface UserService {
    public UserEntity createUser(UserEntity boardEntity);

    public UserEntity getUser(Long boardId);

    public UserEntity updateUser(UserEntity boardEntity);

    public void deleteUser(Long userId);
}
