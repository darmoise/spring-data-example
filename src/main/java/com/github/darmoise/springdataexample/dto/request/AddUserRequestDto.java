package com.github.darmoise.springdataexample.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class AddUserRequestDto {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final LocalDate birthDate;
    private final AnthropometryRequestDto anthropometry;
    private final List<HobbyRequestDto> hobbies;
    private final List<DeviceRequestDto> devices;
}
