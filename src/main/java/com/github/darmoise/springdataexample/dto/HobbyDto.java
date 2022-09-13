package com.github.darmoise.springdataexample.dto;

import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class HobbyDto {
    private final UUID id;
    private final String name;
    private final int startAge;
}
