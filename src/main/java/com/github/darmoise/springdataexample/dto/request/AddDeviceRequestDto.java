package com.github.darmoise.springdataexample.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@ToString
@RequiredArgsConstructor
public class AddDeviceRequestDto {
    private final String name;
    private final LocalDate startDate;
}
