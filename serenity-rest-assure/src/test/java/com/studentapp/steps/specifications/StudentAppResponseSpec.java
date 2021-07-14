package com.studentapp.steps.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

import static com.framework.serenity.core.enums.StatusCode.*;
import static com.studentapp.constants.FileLocations.*;
import static com.studentapp.constants.Messages.STUDENT_ADDED;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

public class StudentAppResponseSpec {

    private File jsonChema;
    private ResponseSpecBuilder responseSpecBuilder;

    public File getJsonChema() {
        return jsonChema;
    }

    public void setJsonChema(File jsonChema) {
        this.jsonChema = jsonChema;
    }

    public ResponseSpecBuilder getResponseSpecBuilder() {
        return responseSpecBuilder;
    }

    public void setResponseSpecBuilder(ResponseSpecBuilder responseSpecBuilder) {
        this.responseSpecBuilder = responseSpecBuilder;
    }

    private void initResponseSpecBuilder(String schemaJsonFilePath) {
        setJsonChema(new File(schemaJsonFilePath));
        setResponseSpecBuilder(new ResponseSpecBuilder());
    }

    private void initResponseSpecBuilder() {
        setResponseSpecBuilder(new ResponseSpecBuilder());
    }

    public ResponseSpecification createStudentSuccessSpec() {
        initResponseSpecBuilder(CREATED_UPDATED_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(CREATED.getStatusCode())
                .expectBody(
                        matchesJsonSchema(getJsonChema()))
                .expectBody("msg", equalTo(STUDENT_ADDED))
                .build();
    }

    public ResponseSpecification getStudentsListSuccessSpec() {
        initResponseSpecBuilder(GET_STUDENTS_LIST_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(SUCCESS.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }

    public ResponseSpecification deleteStudentSuccessSpec() {
        initResponseSpecBuilder();
        return getResponseSpecBuilder()
                .expectStatusCode(NO_CONTENT.getStatusCode())
                .build();
    }

    public ResponseSpecification getExistingStudentSuccessSpec() {
        initResponseSpecBuilder(GET_EXISTING_STUDENTS_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(SUCCESS.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }

    public ResponseSpecification getNotExistingStudentSpec() {
        initResponseSpecBuilder(GET_NOT_EXISTING_STUDENTS_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(NOT_FOUND.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }

    public ResponseSpecification updateStudentSuccessSpec() {
        initResponseSpecBuilder(CREATED_UPDATED_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(SUCCESS.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }
}
