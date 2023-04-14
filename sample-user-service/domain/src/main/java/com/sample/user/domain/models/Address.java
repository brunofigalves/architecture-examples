package com.sample.user.domain.models;

import com.sample.user.domain.models.dtos.AddressDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;

    public AddressDto toDto() {
        return AddressDto.builder()
                .street(street)
                .city(city)
                .state(state)
                .country(country)
                .zipCode(zipCode)
                .build();
    }

    public static Address fromDto(AddressDto dto) {
        return new Address(
                dto.getStreet(),
                dto.getCity(),
                dto.getCountry(),
                dto.getCountry(),
                dto.getZipCode()
        );
    }
}
