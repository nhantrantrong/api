package com.studentapp.requests;

import com.framework.serenity.core.api.RequestBuilder;
import com.framework.serenity.core.enums.StatusCode;
import com.studentapp.model.Student;
import io.restassured.response.ValidatableResponse;

import static com.studentapp.constants.enums.StudentAppRequestURIs.*;


/**
 * Creator: Nhan.Tran Trong
 * This class implements all single api requests basing on Swagger or any api documentation
 */
public class StudentAppRequests extends RequestBuilder {

    public StudentAppRequests(String baseUri) {
        super(baseUri);
    }

    public ValidatableResponse getStudentsList(StatusCode expectedCode) {
        return sendGet(GET_STUDENTS_LIST)
                .statusCode(expectedCode.getStatusCode());
    }

    public ValidatableResponse createStudent(Student student, StatusCode expectedCode) {
        return sendPost(POST_STUDENT, student)
                .statusCode(expectedCode.getStatusCode());
    }

    public ValidatableResponse deleteStudent(int studentId, StatusCode expectedCode) {
        return sendDelete(DELETE_STUDENT, String.valueOf(studentId))
                .statusCode(expectedCode.getStatusCode());
    }

    public ValidatableResponse getStudentById(int studentId, StatusCode expectedCode) {
        return sendGet(GET_STUDENT, String.valueOf(studentId))
                .statusCode(expectedCode.getStatusCode());
    }

    public ValidatableResponse updateStudent(int studentId, Student student, StatusCode expectedCode) {
        return sendPut(PUT_STUDENT, student, String.valueOf(studentId))
                .statusCode(expectedCode.getStatusCode());
    }
}
