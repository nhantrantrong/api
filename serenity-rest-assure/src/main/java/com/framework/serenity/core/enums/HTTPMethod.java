package com.framework.serenity.core.enums;

public enum HTTPMethod {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete");

    private final String httpMethod;

    HTTPMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }
}
