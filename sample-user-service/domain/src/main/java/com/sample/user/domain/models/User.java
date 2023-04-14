package com.sample.user.domain.models;

import com.sample.user.domain.models.dtos.UserDto;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class User {
    private final String userId;
    private final String name;
    private final String email;
    private Address shippingAddress;

    public User(String userId, String name, String email, Address defaultAddress) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.shippingAddress = defaultAddress;
    }

    public UserDto toDto() {
        return UserDto.builder()
                .name(name)
                .userId(userId)
                .email(email)
                .defaultAddress(shippingAddress.toDto())
                .build();
    }

    public static User fromDto(UserDto dto) {
        return new User(
                dto.getUserId(),
                dto.getName(),
                dto.getEmail(),
                Address.fromDto(dto.getDefaultAddress())
        );
    }
}
