package com.studentapp.constants;

public class FileLocations {
    public static final String TESTS_PROPERTIES = "./src/test/resources/configs/tests.properties";

    // -- JSON Schemas
    public static final String JSON_SCHEMAS = "./src/test/resources/schemas";
    public static final String CREATED_UPDATED_RESPONSE_SCHEMA =
            String.format("%s/created_updated_response_schema.json", JSON_SCHEMAS);
    public static final String GET_STUDENTS_LIST_RESPONSE_SCHEMA =
            String.format("%s/get_students_list_response_schema.json", JSON_SCHEMAS);
    public static final String GET_EXISTING_STUDENTS_RESPONSE_SCHEMA =
            String.format("%s/get_existing_student_response_schema.json", JSON_SCHEMAS);
    public static final String GET_NOT_EXISTING_STUDENTS_RESPONSE_SCHEMA =
            String.format("%s/get_not_existing_student_response_schema.json", JSON_SCHEMAS);
}
