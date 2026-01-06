package com.ryctabo.demo.domain.container.valueobjects;

import com.ryctabo.demo.domain.container.InvalidContainerNameException;

import java.util.Objects;
import java.util.regex.Pattern;

public record ContainerName(String value) {
    private static final Pattern REGEX = Pattern.compile("^[A-Z]{2,3}-LPN-\\d{8}(_\\d+)?$");

    public ContainerName {
        Objects.requireNonNull(value, "Container value can not be null!");
        if (value.isBlank()) {
            throw new InvalidContainerNameException("Container value can not be blank!");
        }
        if (!REGEX.matcher(value).matches()) {
            throw new InvalidContainerNameException("Container value (%s) doesn't have correct format!".formatted(value));
        }
    }

    @Override
    public String toString() {
        return this.value;
    }
}
