package com.github.darmoise.springdataexample.util.helper;

import com.github.darmoise.springdataexample.util.DateMapper;
import java.time.Instant;
import java.time.LocalDate;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface DateHelperMapper {
    @Named("mapLocalDateToInstant")
    public static Instant mapLocalDateToInstant(final LocalDate localDate) {
        return DateMapper.mapLocalDateToInstant(localDate);
    }

    @Named("mapInstantToLocalDate")
    public static LocalDate mapInstantToLocalDate(final Instant instant) {
        return DateMapper.mapInstantToLocalDate(instant);
    }
}
