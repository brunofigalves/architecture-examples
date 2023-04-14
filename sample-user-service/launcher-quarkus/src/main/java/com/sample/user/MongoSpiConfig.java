package com.sample.user;

import com.sample.user.domain.repositories.UserRepositoryAdapter;
import com.sample.user.spi.mongodb.adapters.UserMongoRepositoryAdapter;
import com.sample.user.spi.mongodb.repositories.UserRepository;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public class MongoSpiConfig {

    @Produces
    public UserRepositoryAdapter userMongoDbRepositoryAdapter(UserRepository userRepository) {
        return new UserMongoRepositoryAdapter(userRepository);
    }

    @Produces
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
