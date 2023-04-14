package com.sample.user.domain.repositories;

import com.sample.user.domain.models.User;

public interface UserRepositoryAdapter
        extends ReadOnlyRepository<String, User>, WriteOnlyRepository<User> {
}
