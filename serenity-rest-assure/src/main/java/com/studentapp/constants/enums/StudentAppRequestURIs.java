package com.studentapp.constants.enums;

/**
 * @author trantrongnhan
 * <p>
 * Definition for Student Application Function Request URIs
 */
public enum StudentAppRequestURIs {
    GET_STUDENTS_LIST("/list"),
    POST_STUDENT("/"),
    DELETE_STUDENT("/%s"),
    GET_STUDENT("/%s"),
    PUT_STUDENT("/%s");

    private String requestUri;

    /**
     * Initialize of StudentAppRequestURIs enums
     *
     * @param requestUri
     */
    StudentAppRequestURIs(String requestUri) {
        this.requestUri = requestUri;
    }

    /**
     * Get String value of StudentAppRequestURIs enums
     *
     * @return String
     */
    public String getRequestUri() {
        return this.requestUri;
    }

}
