package com.sample.user.api.grpc.controllers.mappers;

import com.sample.user.api.grpc.NewUserRequest;
import com.sample.user.domain.models.dtos.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { AddressDtoMapper.class })
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper(UserDtoMapper.class);

    UserDto toDto(NewUserRequest proto);
}
