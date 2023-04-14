package com.sample.user.spi.mongodb.mappers;

import com.sample.user.domain.models.User;
import com.sample.user.domain.models.dtos.UserDto;
import com.sample.user.spi.mongodb.models.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(uses = { AddressMapper.class })
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(source = "shippingAddress", target = "defaultAddress")
    })
    User toDomainObject(UserEntity persistenceEntity);

    @Mappings({
            @Mapping(source = "defaultAddress", target = "shippingAddress")
    })
    UserEntity toPersistenceObject(UserDto domainEntity);
}
