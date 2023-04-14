package com.sample.user.spi.mongodb.adapters;

import com.sample.user.domain.models.User;
import com.sample.user.domain.repositories.UserRepositoryAdapter;
import com.sample.user.spi.mongodb.mappers.UserMapper;
import com.sample.user.spi.mongodb.models.UserEntity;
import com.sample.user.spi.mongodb.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserMongoRepositoryAdapter implements UserRepositoryAdapter {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserMongoRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
        userMapper = UserMapper.INSTANCE;
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<UserEntity> optionalUserEntity = userRepository.findByUserId(id);
        return optionalUserEntity.map(userMapper::toDomainObject);
    }

    @Override
    public List<User> findAll() {
        List<UserEntity> userEntities = userRepository.findAll().list();
        return userEntities.stream().map(userMapper::toDomainObject).toList();
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toPersistenceObject(user.toDto());
        userRepository.persist(userEntity);
        return userMapper.toDomainObject(userEntity);
    }
}
