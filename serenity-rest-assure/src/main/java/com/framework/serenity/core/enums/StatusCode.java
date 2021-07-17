package com.framework.serenity.core.enums;

/**
 * @author trantrongnhan
 * <p>
 * Definition Status Code enums which will be used to validate the api resquest response status
 */
public enum StatusCode {
    SUCCESS(200),
    CREATED(201),
    NO_CONTENT(204),
    NOT_FOUND(404);

    private final int statusCode;

    /**
     * Constructor to initialize StatusCode enums
     *
     * @param statusCode int
     */
    StatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Get int value of StatusCode enums
     *
     * @return int
     */
    public int getStatusCode() {
        return this.statusCode;
    }
}
