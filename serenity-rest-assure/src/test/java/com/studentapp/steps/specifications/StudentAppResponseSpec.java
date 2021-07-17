package com.studentapp.steps.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import java.io.File;

import static com.framework.serenity.core.enums.StatusCode.*;
import static com.studentapp.constants.FileLocations.*;
import static com.studentapp.constants.Messages.STUDENT_ADDED;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

/**
 * @author trantrongnhan
 * <p>
 * Class implementation for ResponseSepcification which will be used to validate the response (ex: statusCode, header,
 * responseTime, reponseBody, etc.) after sending api request
 */
public class StudentAppResponseSpec {

    private File jsonChema;
    private ResponseSpecBuilder responseSpecBuilder;

    /**
     * Get json schema
     *
     * @return jsonSchema File json to validate Schema of JSON response
     */
    protected File getJsonChema() {
        return jsonChema;
    }

    /**
     * Set json schema
     *
     * @param jsonChema File json schema
     */
    protected void setJsonChema(File jsonChema) {
        this.jsonChema = jsonChema;
    }

    /**
     * Get ResponseSpecificationBuilder
     *
     * @return responseSpecBuilder ResponseSpecBuilder
     */
    public ResponseSpecBuilder getResponseSpecBuilder() {
        return responseSpecBuilder;
    }

    /**
     * Set ResponseSpecificationBuilder
     *
     * @param responseSpecBuilder ResponseSpecBuilder
     */
    public void setResponseSpecBuilder(ResponseSpecBuilder responseSpecBuilder) {
        this.responseSpecBuilder = responseSpecBuilder;
    }

    /**
     * Initialize new ResponseSpecificationBuilder. Generate and setJsonChema, setResponseSpecBuilder
     *
     * @param schemaJsonFilePath File json schema
     */
    private void initResponseSpecBuilder(String schemaJsonFilePath) {
        setJsonChema(new File(schemaJsonFilePath));
        setResponseSpecBuilder(new ResponseSpecBuilder());
    }

    /**
     * Initialize new ResponseSpecificationBuilder without input JSONSchema File. Using when skipping validate Response
     * Body
     */
    private void initResponseSpecBuilder() {
        setResponseSpecBuilder(new ResponseSpecBuilder());
    }

    /**
     * Define Response Validation for Create a new Student Successfully
     *
     * @return ResponseSpecification
     */
    public ResponseSpecification createStudentSuccessSpec() {
        initResponseSpecBuilder(CREATED_UPDATED_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(CREATED.getStatusCode())
                .expectBody(
                        matchesJsonSchema(getJsonChema()))
                .expectBody("msg", equalTo(STUDENT_ADDED))
                .build();
    }

    /**
     * Define Response Validation for Get list of Students Successfully
     *
     * @return ResponseSpecification
     */
    public ResponseSpecification getStudentsListSuccessSpec() {
        initResponseSpecBuilder(GET_STUDENTS_LIST_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(SUCCESS.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }

    /**
     * Define Response Validation for Delete an existing Student Successfully
     *
     * @return ResponseSpecification
     */
    public ResponseSpecification deleteStudentSuccessSpec() {
        initResponseSpecBuilder();
        return getResponseSpecBuilder()
                .expectStatusCode(NO_CONTENT.getStatusCode())
                .build();
    }

    /**
     * Define Response Validation for Get an existing Student Successfully
     *
     * @return ResponseSpecification
     */
    public ResponseSpecification getExistingStudentSuccessSpec() {
        initResponseSpecBuilder(GET_EXISTING_STUDENTS_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(SUCCESS.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }

    /**
     * Define Response Validation for Get a Non-Existing student
     *
     * @return ResponseSpecification
     */
    public ResponseSpecification getNotExistingStudentSpec() {
        initResponseSpecBuilder(GET_NOT_EXISTING_STUDENTS_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(NOT_FOUND.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }

    /**
     * Define Response Validation for Update an existing Student Successfully
     *
     * @return ResponseSpecification
     */
    public ResponseSpecification updateStudentSuccessSpec() {
        initResponseSpecBuilder(CREATED_UPDATED_RESPONSE_SCHEMA);
        return getResponseSpecBuilder()
                .expectStatusCode(SUCCESS.getStatusCode())
                .expectBody(matchesJsonSchema(getJsonChema()))
                .build();
    }
}
