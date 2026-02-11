package com.example.issuecrudservice.controllers;

import com.example.issuecrudservice.dto.UserDto;
import com.example.issuecrudservice.entities.UserEntity;
import com.example.issuecrudservice.mapper.impl.UserMapperImpl;
import com.example.issuecrudservice.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    private final UserMapperImpl userMapper;
    private final UserServiceImpl userService;

    public UserController(UserMapperImpl userMapper, UserServiceImpl userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping(path = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userMapper.mapTo(userService.getUser(userId));
    }

    @PostMapping(path = "/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserEntity  userEntity = userMapper.mapFrom(userDto);
        return userMapper.mapTo(userService.createUser(userEntity));
    }
}

