package com.ryctabo.demo.infrastructure.repository.container;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "container")
public class ContainerEntity {

    @Id private String id;
    private String name;
    private Integer number;
    private String locationName;
    private String warehouse;
    private String country;
    private Instant createdAt;
}
