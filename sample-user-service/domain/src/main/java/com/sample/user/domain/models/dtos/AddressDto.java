package com.sample.user.domain.models.dtos;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AddressDto {
    String street;
    String city;
    String state;
    String country;
    String zipCode;
}
