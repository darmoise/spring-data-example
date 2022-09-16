package com.github.darmoise.springdataexample.domain.model;

import com.github.darmoise.springdataexample.dto.HobbyDto;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class User {
    private final UUID id;
    private final long version;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final LocalDate birthDate;
    private final List<HobbyDto> hobbies;
}
