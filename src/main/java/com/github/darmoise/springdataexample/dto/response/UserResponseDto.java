package com.github.darmoise.springdataexample.dto.response;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.github.darmoise.springdataexample.domain.model.Anthropometry;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class UserResponseDto {
    private final UUID id;
    private final long version;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final LocalDate birthDate;
    private final Anthropometry anthropometry;
    private final List<HobbyResponseDto> hobbies;
    private final List<DeviceResponseDto> devices;
}
