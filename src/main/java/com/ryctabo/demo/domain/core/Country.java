package com.ryctabo.demo.domain.core;

import java.util.Objects;

public record Country(String code) {
    public Country {
        Objects.requireNonNull(code, "Country code can not be null!");
        if (code.isBlank()) throw new IllegalArgumentException("Country code can not be blank!");
        if (code.length() != 2) {
            throw new IllegalArgumentException("Country code (%s) has invalid format!".formatted(code));
        }
    }
    @Override
    public String toString() {
        return this.code;
    }
}
