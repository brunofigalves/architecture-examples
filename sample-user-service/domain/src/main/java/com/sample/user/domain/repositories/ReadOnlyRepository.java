package com.sample.user.domain.repositories;

import java.util.List;
import java.util.Optional;

public interface ReadOnlyRepository<K,T> {
    Optional<T> findById(K id);

    List<T> findAll();
}
