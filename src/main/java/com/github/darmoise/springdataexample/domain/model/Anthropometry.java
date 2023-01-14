package com.github.darmoise.springdataexample.domain.model;

import lombok.Data;

import java.util.UUID;

@Data
public class Anthropometry {
    private final UUID id;
    private final int height;
    private final int weight;
}
