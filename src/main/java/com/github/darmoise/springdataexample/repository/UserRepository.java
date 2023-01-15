package com.github.darmoise.springdataexample.repository;

import com.github.darmoise.springdataexample.domain.entity.PersonEntity;
import java.time.Instant;
import java.util.UUID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<PersonEntity, UUID> {
    @Modifying
    @Transactional
    @Query("update versioned PersonEntity u set u.birthDate = :birthDate where u.id = :userId")
    void changeBirthDate(
        UUID userId,
        Instant birthDate
    );
}
