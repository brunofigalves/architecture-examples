package com.sample.user.api.rest.controllers.impl;

import com.sample.user.api.controllers.UserController;
import com.sample.user.api.rest.controllers.UserRestController;
import com.sample.user.domain.models.dtos.UserDto;

import java.util.List;

public class UserRestControllerImpl implements UserRestController {

    private final UserController userController;

    public UserRestControllerImpl(UserController userController) {
        this.userController = userController;
    }

    @Override
    public List<UserDto> getUsers() {
        return userController.getUsers();
    }

    @Override
    public UserDto getUser(String userId) {
        return userController.getUser(userId);
    }

    @Override
    public UserDto newUser(UserDto userDto) {
        return userController.newUser(userDto);
    }
}
