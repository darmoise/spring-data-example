package com.github.darmoise.springdataexample.controller;

import com.github.darmoise.springdataexample.dto.request.AddPersonRequestDto;
import com.github.darmoise.springdataexample.dto.response.PersonResponseDto;
import com.github.darmoise.springdataexample.service.UserService;
import com.github.darmoise.springdataexample.util.UserMapper;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("${service.rest-api}/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping
    public List<PersonResponseDto> getUsers() {
        return userService.getUsers()
            .stream()
            .map(userMapper::modelToDto)
            .toList();
    }

    @GetMapping("/{userId}")
    public PersonResponseDto getUser(@PathVariable UUID userId) {
        return userMapper.modelToDto(
            userService.getUser(userId)
        );
    }

    @PostMapping
    public PersonResponseDto addUser(@RequestBody AddPersonRequestDto dto) {
        val user = userService.addUser(userMapper.dtoToModel(dto));

        return userMapper.modelToDto(user);
    }

    @DeleteMapping
    public void deleteAll() {
        userService.deleteAll();
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
    }

    @PostMapping("/{userId}/birth-date/{birthDate}")
    public void changeBirthDate(
        @PathVariable final UUID userId,
        @PathVariable
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        final LocalDate birthDate
    ) {
        userService.changeBirthDate(userId, birthDate);
    }
}
