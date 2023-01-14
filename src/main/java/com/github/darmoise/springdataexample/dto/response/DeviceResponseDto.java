package com.github.darmoise.springdataexample.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@ToString
@RequiredArgsConstructor
public class DeviceResponseDto {
    private final UUID id;
    private final String name;
    private final LocalDate startDate;
    private final LocalDate createdAt;
    private final LocalDate updatedAt;
}
