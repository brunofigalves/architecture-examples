package com.sample.user.spi.mongodb.mappers;

import com.sample.user.domain.models.Address;
import com.sample.user.domain.models.dtos.AddressDto;
import com.sample.user.spi.mongodb.models.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address toDomainObject(AddressEntity persistenceEntity);

    AddressEntity toPersistenceObject(AddressDto dto);
}
