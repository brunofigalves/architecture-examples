package com.sample.user.api.controllers.impl;

import com.sample.user.api.controllers.UserController;
import com.sample.user.api.rest.controllers.UserRestController;
import com.sample.user.domain.models.dtos.UserDto;
import com.sample.user.domain.services.UserService;

import java.util.List;

public class UserControllerImpl implements UserController, UserRestController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @Override
    public UserDto getUser(String userId) {
        return userService.getUserById(userId);
    }

    @Override
    public UserDto newUser(UserDto userDto) {
        return userService.newUser(userDto);
    }
}
