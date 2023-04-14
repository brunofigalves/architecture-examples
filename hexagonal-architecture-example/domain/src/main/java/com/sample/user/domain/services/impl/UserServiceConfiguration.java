package com.sample.user.domain.services.impl;

import com.sample.user.domain.repositories.UserRepositoryAdapter;
import lombok.Value;

@Value
public class UserServiceConfiguration {
    UserRepositoryAdapter userRepositoryAdapter;
}
