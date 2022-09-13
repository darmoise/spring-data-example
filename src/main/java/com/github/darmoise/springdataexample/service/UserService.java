package com.github.darmoise.springdataexample.service;

import com.github.darmoise.springdataexample.domain.model.User;
import com.github.darmoise.springdataexample.repository.UserRepository;
import com.github.darmoise.springdataexample.util.UserMapper;
import com.google.common.collect.Streams;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public User addUser(User user) {
        val entity = userMapper.modelToEntity(user);
        return userMapper.entityToModel(userRepository.save(entity));
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    public User getUser(UUID userId) {
        return userRepository.findById(userId)
            .map(userMapper::entityToModel)
            .orElseThrow();
    }

    public List<User> getUsers() {
        return Streams.stream(userRepository.findAll())
            .map(userMapper::entityToModel)
            .toList();
    }
}
