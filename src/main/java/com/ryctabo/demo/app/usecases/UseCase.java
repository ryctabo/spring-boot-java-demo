package com.ryctabo.demo.app.usecases;

public interface UseCase<C, R> {
    R invoke(C command);
}
