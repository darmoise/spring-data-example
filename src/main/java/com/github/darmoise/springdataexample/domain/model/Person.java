package com.github.darmoise.springdataexample.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
@RequiredArgsConstructor
public class Person {
    private final UUID id;
    private final long version;
    private final String firstName;
    private final String lastName;
    private final String username;
    private final LocalDate birthDate;
    private final Anthropometry anthropometry;
    private final List<Hobby> hobbies;
    private final List<Device> devices;
}
