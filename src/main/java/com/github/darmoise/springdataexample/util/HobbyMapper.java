package com.github.darmoise.springdataexample.util;

import com.github.darmoise.springdataexample.domain.entity.HobbyEntity;
import com.github.darmoise.springdataexample.domain.model.Hobby;
import com.github.darmoise.springdataexample.util.helper.DateHelperMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {
        DateHelperMapper.class
    }
)
public interface HobbyMapper {
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
    HobbyEntity modelToEntity(Hobby entity);

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
    Hobby modelToEntity(HobbyEntity model);
}
