package com.github.darmoise.springdataexample.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "anthropometries")
@Getter
@Setter
@ToString
public class AnthropometryEntity {
    @Id
    @GeneratedValue(
        generator = "UUID"
    )
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    private int height;
    private int weight;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @OneToOne(
        fetch = FetchType.EAGER,
        optional = false
    )
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
