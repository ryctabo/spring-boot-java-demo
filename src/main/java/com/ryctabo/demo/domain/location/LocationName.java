package com.ryctabo.demo.domain.location;

import java.util.Objects;
import java.util.regex.Pattern;

public record LocationName(String value) {
    private static final Pattern REGEX = Pattern.compile("^[A-Z]{2,3}-[A-Z]{2,8}(-[A-Z]\\d{1,2}){1,6}(_\\d+)?$");

    public LocationName {
        Objects.requireNonNull(value, "Location value can not be null!");
        if (value.isBlank()) throw new IllegalArgumentException("Location value can not be empty!");
        if (!REGEX.matcher(value).matches()) {
            throw new IllegalArgumentException("Location value (%s) has invalid format!".formatted(value));
        }
    }

    @Override
    public String toString() {
        return this.value;
    }
}
