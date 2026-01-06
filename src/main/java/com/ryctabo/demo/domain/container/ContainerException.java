package com.ryctabo.demo.domain.container;

import com.ryctabo.demo.domain.BusinessException;

public class ContainerException extends BusinessException {
    public ContainerException(String message) {
        super(message);
    }
}
