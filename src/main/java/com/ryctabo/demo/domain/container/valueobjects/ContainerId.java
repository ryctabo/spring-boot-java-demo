package com.ryctabo.demo.domain.container.valueobjects;

import java.util.Objects;

public record ContainerId(String value) {
    public ContainerId {
        Objects.requireNonNull(value, "Container ID can not be null!");
        if (value.isBlank()) throw new IllegalArgumentException("Container ID can not be empty!");
    }

    @Override
    public String toString() {
        return value;
    }
}
