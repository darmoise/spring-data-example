package com.github.darmoise.springdataexample.util;

import com.github.darmoise.springdataexample.domain.entity.PersonEntity;
import com.github.darmoise.springdataexample.domain.model.User;
import com.github.darmoise.springdataexample.dto.request.AddUserRequestDto;
import com.github.darmoise.springdataexample.dto.response.UserResponseDto;
import com.github.darmoise.springdataexample.util.helper.DateHelperMapper;

import java.util.ArrayList;
import java.util.Optional;

import org.mapstruct.*;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    uses = {
        DateHelperMapper.class,
        HobbyMapper.class
    }
)
public abstract class UserMapper {
    public abstract User dtoToModel(AddUserRequestDto dto);

    @Mapping(
        source = "birthDate",
        target = "birthDate",
        qualifiedByName = "mapLocalDateToInstant"
    )
    public abstract PersonEntity modelToEntity(User source);

    @Mapping(
        source = "birthDate",
        target = "birthDate",
        qualifiedByName = "mapInstantToLocalDate"
    )
    public abstract User entityToModel(PersonEntity source);

    public abstract UserResponseDto modelToDto(User source);

    @AfterMapping
    protected void after(@MappingTarget final PersonEntity entity) {
        Optional.ofNullable(entity.getHobbies()).ifPresentOrElse(
            hobbies -> hobbies.forEach(item -> item.setUser(entity)),
            () -> entity.setHobbies(new ArrayList<>())
        );
        Optional.ofNullable(entity.getAnthropometry()).ifPresentOrElse(
            item -> item.setUser(entity),
            () -> entity.setHobbies(new ArrayList<>())
        );
    }
}
