package com.ryctabo.demo.infrastructure.http;

import java.time.Instant;

public record ContainerResponse (
        String id,
        String name,
        int number,
        String locationName,
        String warehouse,
        String country,
        Instant createdAt
) {}
