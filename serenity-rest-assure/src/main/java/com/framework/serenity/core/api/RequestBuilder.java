package com.framework.serenity.core.api;

import com.framework.serenity.core.enums.HTTPMethod;
import com.studentapp.constants.enums.StudentAppRequestURIs;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

import static com.framework.serenity.core.enums.HTTPMethod.*;

public class RequestBuilder {
    private String baseUri;
    private RequestSpecification request;

    public RequestSpecification getRequest() {
        return request;
    }

    public void setRequest(RequestSpecification request) {
        this.request = request;
    }

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    public RequestBuilder(String baseUri) {
        setBaseUri(baseUri);
    }

    public RequestSpecification initRequest() {
        RestAssured.baseURI = getBaseUri();
        setRequest(
                SerenityRest.given()
                        .when());
        return getRequest();
    }

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

    public ValidatableResponse sendGet(StudentAppRequestURIs uri, Object... params) {
        RequestSpecification request = initRequest();
        return send(GET, uri, request, params);
    }

    public ValidatableResponse sendPost(StudentAppRequestURIs uri, Object body) {
        RequestSpecification request = initRequest();
        request.contentType(ContentType.JSON)
                .body(body);
        return send(POST, uri, request);
    }

    public ValidatableResponse sendDelete(StudentAppRequestURIs uri, Object... params) {
        RequestSpecification request = initRequest();
        return send(DELETE, uri, request, params);
    }

    public ValidatableResponse sendPut(StudentAppRequestURIs uri, Object body, Object... params) {
        RequestSpecification request = initRequest();
        request.contentType(ContentType.JSON)
                .body(body);
        return send(PUT, uri, request, params);
    }
}
