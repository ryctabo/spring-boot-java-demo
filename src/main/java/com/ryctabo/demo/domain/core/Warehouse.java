package com.ryctabo.demo.domain.core;

import java.util.Objects;

public record Warehouse(String code) {
    public Warehouse {
        Objects.requireNonNull(code, "Warehouse code can not be null!");
        if (code.isBlank()) throw new IllegalArgumentException("Warehouse code can not be blank!");
        if (code.length() < 2 || code.length() > 3) {
            throw new IllegalArgumentException("Warehouse code (%s) has invalid format!".formatted(code));
        }
    }
    @Override
    public String toString() {
        return this.code;
    }
}
