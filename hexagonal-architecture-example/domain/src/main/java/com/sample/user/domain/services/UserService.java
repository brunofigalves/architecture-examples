package com.sample.user.domain.services;

import com.sample.user.domain.models.dtos.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getUsers();

    UserDto getUserById(String userId);

    UserDto newUser(UserDto userDto);
}
