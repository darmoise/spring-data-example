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
@Table(name = "anthropometry")
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

    @Column
    private int height;

    @Column
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
    @JoinColumn(name = "person_id")
    private PersonEntity user;
}
