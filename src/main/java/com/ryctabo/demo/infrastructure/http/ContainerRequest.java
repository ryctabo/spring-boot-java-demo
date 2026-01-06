package com.ryctabo.demo.infrastructure.http;

public record ContainerRequest(
        String name,
        String location,
        String country
) {
}
