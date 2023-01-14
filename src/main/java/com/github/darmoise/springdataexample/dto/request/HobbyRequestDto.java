package com.github.darmoise.springdataexample.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class HobbyRequestDto {
    private final String name;
    private final int startAge;
}
