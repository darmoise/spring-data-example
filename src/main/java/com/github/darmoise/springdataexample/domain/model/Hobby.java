package com.github.darmoise.springdataexample.domain.model;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Hobby {
    private final UUID id;
    private final String name;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;
    private final int startAge;
}
