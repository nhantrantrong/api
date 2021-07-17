package com.framework.serenity.core.api;

import com.framework.serenity.core.enums.HTTPMethod;
import com.studentapp.constants.enums.StudentAppRequestURIs;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import static com.framework.serenity.core.enums.HTTPMethod.*;

/**
 * @author trantrongnhan
 * <p>
 * Class implementations for building API Requests. These methods will wrap up SerenityRest, setup baseUri
 */
public class RequestBuilder {
    private String baseUri;
    private RequestSpecification request;

    /**
     * Get request specification
     *
     * @return request RequestSpecification
     */
    public RequestSpecification getRequest() {
        return request;
    }

    /**
     * Set request specification
     *
     * @param request RequestSpecification
     */
    public void setRequest(RequestSpecification request) {
        this.request = request;
    }

    /**
     * Get current baseUri
     *
     * @return baseUri String
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * Set new baseUri
     *
     * @param baseUri String
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * Init RequestBuilder Class with setup baseUri value
     *
     * @param baseUri String
     */
    public RequestBuilder(String baseUri) {
        setBaseUri(baseUri);
    }

    /**
     * Init Request Specification including set baseUri or any more configurations before sending request
     *
     * @return RequestSpecification
     */
    public RequestSpecification initRequest() {
        RestAssured.baseURI = getBaseUri();
        setRequest(
                SerenityRest.given()
                        .when());
        return getRequest();
    }

    /**
     * Wrapped up send POST / PUT / GET / DELETE methods of SerenityRequest
     *
     * @param method        HTTPMethod - POST / PUT / GET / DELETE
     * @param uri           uri of function
     * @param requestSender RequestSpecification
     * @param params        optional any Query Parameters
     * @return ValidatableResponse
     */
    private ValidatableResponse send(HTTPMethod method, StudentAppRequestURIs uri, RequestSpecification requestSender,
                                     Object... params) {
        requestSender.log()
                .all();
        String uriWithParams = uri.getRequestUri().contains("%s") ?
                String.format(uri.getRequestUri(), params) : uri.getRequestUri();

        return switch (method) {
            case POST -> requestSender.post(uriWithParams)
                    .then()
                    .log()
                    .all();
            case PUT -> requestSender.put(uriWithParams)
                    .then()
                    .log()
                    .all();
            case GET -> requestSender.get(uriWithParams)
                    .then()
                    .log()
                    .all();
            default -> requestSender.delete(uriWithParams)
                    .then()
                    .log()
                    .all();
        };
    }

    /**
     * Send a GET request api
     *
     * @param uri    String
     * @param params Optional params
     * @return ValidatableResponse
     */
    public ValidatableResponse sendGet(StudentAppRequestURIs uri, Object... params) {
        RequestSpecification request = initRequest();
        return send(GET, uri, request, params);
    }

    /**
     * Send a POST request api
     *
     * @param uri  String
     * @param body JSON request body
     * @return ValidatableResponse
     */
    public ValidatableResponse sendPost(StudentAppRequestURIs uri, Object body) {
        RequestSpecification request = initRequest();
        request.contentType(ContentType.JSON)
                .body(body);
        return send(POST, uri, request);
    }

    /**
     * Send a DELETE request api
     *
     * @param uri    String
     * @param params Optional params
     * @return ValidatableResponse
     */
    public ValidatableResponse sendDelete(StudentAppRequestURIs uri, Object... params) {
        RequestSpecification request = initRequest();
        return send(DELETE, uri, request, params);
    }

    /**
     * Send a PUT request api
     *
     * @param uri    String
     * @param body   JSON request body
     * @param params Optional params
     * @return ValidatableResponse
     */
    public ValidatableResponse sendPut(StudentAppRequestURIs uri, Object body, Object... params) {
        RequestSpecification request = initRequest();
        request.contentType(ContentType.JSON)
                .body(body);
        return send(PUT, uri, request, params);
    }
}
