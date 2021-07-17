package com.studentapp.response;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author trantrongnhan
 * @implNote This class could be considered as deprecated when applying DTO for enhancement
 * <p>
 * Class implementation for Deserializing JSON response to Object for validation in Spec or reusing returned data
 */
public class ErrorResponse {
    String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @JsonCreator
    public ErrorResponse(String error) {
        this.error = error;
    }
}
