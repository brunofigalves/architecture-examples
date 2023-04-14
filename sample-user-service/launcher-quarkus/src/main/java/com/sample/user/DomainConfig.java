package com.sample.user;

import com.sample.user.domain.repositories.UserRepositoryAdapter;
import com.sample.user.domain.services.UserService;
import com.sample.user.domain.services.impl.UserServiceConfiguration;
import com.sample.user.domain.services.impl.UserServiceImpl;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;

@Dependent
public class DomainConfig {

    @Produces
    public UserService userService(UserServiceConfiguration userServiceConfiguration) {
        return new UserServiceImpl(userServiceConfiguration);
    }

    @Produces
    public UserServiceConfiguration userServiceConfiguration(UserRepositoryAdapter userRepositoryAdapter) {
        return new UserServiceConfiguration(userRepositoryAdapter);
    }
}
