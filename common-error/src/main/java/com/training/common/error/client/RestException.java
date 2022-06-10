package com.training.common.error.client;

import com.training.common.error.ErrorObj;

public class RestException extends RuntimeException {
    private final ErrorObj errorObj;

    public RestException(ErrorObj errorObj) {
        this.errorObj = errorObj;
    }

    public ErrorObj getErrorObj() {
        return errorObj;
    }
}
