package com.sample.user.api.grpc.controllers.mappers;

import com.sample.user.api.grpc.AddressResponse;
import com.sample.user.domain.models.dtos.AddressDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressDtoMapper {
    AddressDtoMapper INSTANCE = Mappers.getMapper(AddressDtoMapper.class);

    AddressDto toDto(AddressResponse proto);
}
