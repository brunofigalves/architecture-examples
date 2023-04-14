package com.sample.user.domain.models.dtos;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class UserDto {
    String userId;
    String name;
    String email;
    AddressDto defaultAddress;
}
