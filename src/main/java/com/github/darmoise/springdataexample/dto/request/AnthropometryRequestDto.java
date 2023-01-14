package com.github.darmoise.springdataexample.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class AnthropometryRequestDto {
    private final int height;
    private final int weight;
}
