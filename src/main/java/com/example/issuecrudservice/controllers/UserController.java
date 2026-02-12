package com.example.issuecrudservice.controllers;

import com.example.issuecrudservice.dto.UserDto;
import com.example.issuecrudservice.entities.UserEntity;
import com.example.issuecrudservice.mapper.impl.UserMapperImpl;
import com.example.issuecrudservice.services.impl.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserMapperImpl userMapper;
    private final UserServiceImpl userService;

    public UserController(UserMapperImpl userMapper, UserServiceImpl userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public UserDto getUser(@RequestBody UserDto userDto) {
        return userMapper.mapTo(userService.getUser(userDto.getUserId()));
    }

    @PostMapping(path = "/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        UserEntity  userEntity = userMapper.mapFrom(userDto);
        return userMapper.mapTo(userService.createUser(userEntity));
    }

    @PutMapping(path = "/users")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.mapFrom(userDto);
        return userMapper.mapTo(userService.updateUser(userEntity));
    }

    @DeleteMapping(path = "/users")
    public ResponseEntity<UserDto> deleteUser(@RequestBody UserDto userDto) {
        userService.deleteUser(userDto.getUserId());
        return ResponseEntity.ok().build();
    }
}

