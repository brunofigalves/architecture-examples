package com.sample.user.api.controllers;

import com.sample.user.domain.models.dtos.UserDto;

import java.util.List;

public interface UserController {
    List<UserDto> getUsers();
    UserDto getUser(String userId);
    UserDto newUser(UserDto dto);
}
