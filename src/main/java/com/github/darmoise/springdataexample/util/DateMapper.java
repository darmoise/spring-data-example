package com.github.darmoise.springdataexample.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateMapper {
    public static Instant mapLocalDateToInstant(final LocalDate localDate) {
        return localDate != null ?
            localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()
            : null;
    }

    public static LocalDate mapInstantToLocalDate(final Instant instant) {
        return instant != null ?
            LocalDate.ofInstant(instant, ZoneId.systemDefault())
            : null;
    }
}
