package com.github.darmoise.springdataexample.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@ToString
@RequiredArgsConstructor
public class AddPersonRequestDto {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final LocalDate birthDate;
    private final AddAnthropometryRequestDto anthropometry;
    private final List<AddHobbyRequestDto> hobbies;
    private final List<AddDeviceRequestDto> devices;
}
