package com.github.darmoise.springdataexample.service;

import com.github.darmoise.springdataexample.domain.model.Person;
import com.github.darmoise.springdataexample.repository.UserRepository;
import com.github.darmoise.springdataexample.util.DateMapper;
import com.github.darmoise.springdataexample.util.UserMapper;
import com.google.common.collect.Streams;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Person addUser(Person user) {
        val entity = userMapper.modelToEntity(user);
        return userMapper.entityToModel(userRepository.save(entity));
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    public void changeBirthDate(
        final UUID userId,
        final LocalDate birthDate
    ) {
        userRepository.changeBirthDate(
            userId,
            DateMapper.mapLocalDateToInstant(birthDate)
        );
    }

    public Person getUser(UUID userId) {
        return userRepository.findById(userId)
            .map(userMapper::entityToModel)
            .orElseThrow();
    }

    public List<Person> getUsers() {
        return Streams.stream(userRepository.findAll())
            .map(userMapper::entityToModel)
            .toList();
    }

    public void deleteAll() {
        userRepository.deleteAll();;
    }

}
