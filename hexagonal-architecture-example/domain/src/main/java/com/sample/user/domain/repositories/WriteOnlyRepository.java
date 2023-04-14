package com.sample.user.domain.repositories;

public interface WriteOnlyRepository<T> {
    T save(T entity);
}
