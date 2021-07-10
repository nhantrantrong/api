package com.studentapp.constants.enums;

public enum StatusCode {
    SUCCESS(200),
    CREATED(201),
    NO_CONTENT(204),
    NOT_FOUND(404)
    ;

    private final int statusCode;

    StatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
