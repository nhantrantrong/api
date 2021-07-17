package com.framework.serenity.core.enums;

/**
 * @author trantrongnhan
 * <p>
 * Definition of HTTP method enums which will be invoked when calling send request
 */
public enum HTTPMethod {
    GET("get"),
    POST("post"),
    PUT("put"),
    DELETE("delete");

    private final String httpMethod;

    /**
     * Constructor to initialize HTTPMethod
     *
     * @param httpMethod String
     */
    HTTPMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * Get String value of HTTPMethod enums
     *
     * @return String
     */
    public String getHttpMethod() {
        return this.httpMethod;
    }
}
