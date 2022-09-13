package com.github.darmoise.springdataexample.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UserDto {
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final LocalDate birthDate;
    private final List<HobbyDto> hobbies;
}
