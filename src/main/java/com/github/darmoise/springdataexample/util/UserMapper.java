package com.github.darmoise.springdataexample.util;

import com.github.darmoise.springdataexample.domain.entity.UserEntity;
import com.github.darmoise.springdataexample.domain.model.User;
import com.github.darmoise.springdataexample.dto.UserDto;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Optional;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract User dtoToModel(UserDto dto);

    @Mapping(
        target = "birthDate",
        expression = "java( mapLocalDateToInstant(source) )"
    )
    public abstract UserEntity modelToEntity(User source);

    @Mapping(
        target = "birthDate",
        expression = "java( mapInstantToLocalDate(source) )"
    )
    public abstract User entityToModel(UserEntity source);

    public abstract UserDto modelToDto(User source);

    protected Instant mapLocalDateToInstant(final User user) {
        return user.getBirthDate().atStartOfDay(ZoneId.systemDefault()).toInstant();
    }

    protected LocalDate mapInstantToLocalDate(final UserEntity user) {
        return LocalDate.ofInstant(user.getBirthDate(), ZoneId.systemDefault());
    }

    @AfterMapping
    protected void after(@MappingTarget final UserEntity entity) {
        Optional.ofNullable(entity.getHobbies()).ifPresentOrElse(
            hobbies -> hobbies.forEach(item -> {
                item.setUser(entity);
            }),
            () -> entity.setHobbies(new ArrayList<>())
        );
    }
}
