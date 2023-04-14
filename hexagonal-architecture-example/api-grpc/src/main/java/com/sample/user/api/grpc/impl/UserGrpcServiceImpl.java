package com.sample.user.api.grpc.impl;

import com.sample.user.api.controllers.UserController;
import com.sample.user.api.grpc.*;
import com.sample.user.api.grpc.mappers.UserDtoMapper;
import com.sample.user.domain.models.dtos.UserDto;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.List;

@GrpcService
public class UserGrpcServiceImpl implements UserGrpcService {
    private final UserController userController;
    private final UserDtoMapper userDtoMapper;

    public UserGrpcServiceImpl(
            UserController userController) {
        this.userController = userController;
        this.userDtoMapper = UserDtoMapper.INSTANCE;
    }

    @Override
    public Uni<UserResponse> getUser(GetUserRequest request) {
        UserDto dto = userController.getUser(request.getUserId());
        return Uni.createFrom()
                .item(() -> toUserResponse(dto));
    }

    @Override
    public Multi<UserResponse> getUsers(VoidRequest request) {
        List<UserDto> dtos = userController.getUsers();
        return Multi.createFrom()
                .iterable(dtos.stream().map(this::toUserResponse).toList());
    }

    @Override
    public Uni<UserResponse> newUser(NewUserRequest request) {
        UserDto newUserDto = userDtoMapper.toDto(request);
        UserDto dto = userController.newUser(newUserDto);
        return Uni.createFrom()
                .item(() -> toUserResponse(dto));
    }

    private UserResponse toUserResponse(UserDto dto) {
        return UserResponse.newBuilder()
                .setUserId(dto.getUserId())
                .setName(dto.getName())
                .setEmail(dto.getEmail())
                .build();
    }
}
