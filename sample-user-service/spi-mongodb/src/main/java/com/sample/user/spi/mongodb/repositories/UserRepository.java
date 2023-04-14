package com.sample.user.spi.mongodb.repositories;

import com.sample.user.spi.mongodb.models.UserEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import java.util.Optional;

public class UserRepository implements PanacheMongoRepository<UserEntity> {
    public Optional<UserEntity> findByUserId(String userId) {
        return find("user_id", userId).singleResultOptional();
    }

}
