package com.github.darmoise.springdataexample.util;

import com.github.darmoise.springdataexample.domain.entity.UserEntity;
import com.github.darmoise.springdataexample.domain.model.User;
import com.github.darmoise.springdataexample.dto.request.AddUserRequestDto;
import com.github.darmoise.springdataexample.dto.response.UserResponseDto;
import com.github.darmoise.springdataexample.util.helper.DateHelperMapper;
import java.util.ArrayList;
import java.util.Optional;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(
    componentModel = "spring",
    uses = {
        DateHelperMapper.class
    }
)
public abstract class UserMapper {
    public abstract User dtoToModel(AddUserRequestDto dto);

    @Mapping(
        source = "birthDate",
        target = "birthDate",
        qualifiedByName = "mapLocalDateToInstant"
    )
    @Mapping(
        source = "createdAt",
        target = "createdAt",
        qualifiedByName = "mapLocalDateToInstant"
    )
    @Mapping(
        source = "updatedAt",
        target = "updatedAt",
        qualifiedByName = "mapLocalDateToInstant"
    )
    public abstract UserEntity modelToEntity(User source);

    @Mapping(
        source = "birthDate",
        target = "birthDate",
        qualifiedByName = "mapInstantToLocalDate"
    )
    @Mapping(
        source = "createdAt",
        target = "createdAt",
        qualifiedByName = "mapInstantToLocalDate"
    )
    @Mapping(
        source = "updatedAt",
        target = "updatedAt",
        qualifiedByName = "mapInstantToLocalDate"
    )
    public abstract User entityToModel(UserEntity source);

    public abstract UserResponseDto modelToDto(User source);

    @AfterMapping
    protected void after(@MappingTarget final UserEntity entity) {
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
