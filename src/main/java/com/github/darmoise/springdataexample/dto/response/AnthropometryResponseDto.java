package com.github.darmoise.springdataexample.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@RequiredArgsConstructor
public class AnthropometryResponseDto {
    private final UUID id;
    private final int height;
    private final int weight;
}
