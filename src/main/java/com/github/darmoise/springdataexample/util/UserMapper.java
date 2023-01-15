package com.github.darmoise.springdataexample.util;

import com.github.darmoise.springdataexample.domain.entity.PersonEntity;
import com.github.darmoise.springdataexample.domain.model.Person;
import com.github.darmoise.springdataexample.dto.request.AddPersonRequestDto;
import com.github.darmoise.springdataexample.dto.response.PersonResponseDto;
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
    public abstract Person dtoToModel(AddPersonRequestDto dto);

    @Mapping(
        source = "birthDate",
        target = "birthDate",
        qualifiedByName = "mapLocalDateToInstant"
    )
    public abstract PersonEntity modelToEntity(Person source);

    @Mapping(
        source = "birthDate",
        target = "birthDate",
        qualifiedByName = "mapInstantToLocalDate"
    )
    public abstract Person entityToModel(PersonEntity source);

    public abstract PersonResponseDto modelToDto(Person source);

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
