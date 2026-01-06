package com.ryctabo.demo.infrastructure.repository;

public interface Converter<D, E> {
    D toDomain(E entity);
    E toEntity(D data);
}
