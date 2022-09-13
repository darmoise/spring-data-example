package com.github.darmoise.springdataexample.repository;

import com.github.darmoise.springdataexample.domain.entity.UserEntity;
import java.util.UUID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {
}
