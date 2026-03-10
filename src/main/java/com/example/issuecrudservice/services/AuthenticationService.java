package com.example.issuecrudservice.services;

import com.example.issuecrudservice.dto.LoginUserDto;
import com.example.issuecrudservice.dto.RegisterUserDto;
import com.example.issuecrudservice.entities.UserEntity;

public interface AuthenticationService {
    public UserEntity signup(RegisterUserDto input);
    public UserEntity authenticate(LoginUserDto input);
}
