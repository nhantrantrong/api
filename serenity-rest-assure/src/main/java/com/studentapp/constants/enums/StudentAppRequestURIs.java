package com.studentapp.constants.enums;

public enum StudentAppRequestURIs {
    GET_STUDENTS_LIST("/list"),
    POST_STUDENT("/"),
    DELETE_STUDENT("/%s"),
    GET_STUDENT("/%s"),
    PUT_STUDENT("/%s");

    private String requestUri;

    StudentAppRequestURIs(String requestUri) {
        this.requestUri = requestUri;
    }

    public String getRequestUri() {
        return this.requestUri;
    }

    public StudentAppRequestURIs updateRequestUriWithParams(Object... params) {
        this.requestUri = String.format(requestUri, params);
        return this;
    }

}
