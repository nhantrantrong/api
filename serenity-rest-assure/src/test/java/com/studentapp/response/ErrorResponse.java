package com.studentapp.response;

import com.fasterxml.jackson.annotation.JsonCreator;

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
