package com.sample.user.domain.services.impl;

import com.sample.user.domain.exceptions.UserServiceException;
import com.sample.user.domain.models.User;
import com.sample.user.domain.models.dtos.UserDto;
import com.sample.user.domain.repositories.UserRepositoryAdapter;
import com.sample.user.domain.services.UserService;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepositoryAdapter userRepositoryAdapter;

    public UserServiceImpl(UserServiceConfiguration serviceConfig) {
        this.userRepositoryAdapter = serviceConfig.getUserRepositoryAdapter();
    }

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepositoryAdapter.findAll();
        return users.stream().map(User::toDto).toList();
    }

    @Override
    public UserDto getUserById(String userId) {
        Optional<User> userOptional = userRepositoryAdapter.findById(userId);
        User user = userOptional.orElseThrow(UserServiceException::new);
        return user.toDto();
    }

    @Override
    public UserDto newUser(UserDto userDto) {
        User newUser = User.fromDto(userDto);
        newUser = userRepositoryAdapter.save(newUser);
        return newUser.toDto();
    }
}
