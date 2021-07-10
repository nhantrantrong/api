package com.studentapp.requests;

import com.framework.serenity.core.api.RequestBuilder;
import com.studentapp.constants.enums.StatusCode;
import com.studentapp.model.Student;
import io.restassured.response.ValidatableResponse;

import static com.studentapp.constants.enums.StudentAppRequestURIs.*;

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
        return sendDelete(DELETE_STUDENT.updateRequestUriWithParams(String.valueOf(studentId)))
                .statusCode(expectedCode.getStatusCode());
    }

    public ValidatableResponse getStudentById(int studentId, StatusCode expectedCode) {
        return sendGet(GET_STUDENT.updateRequestUriWithParams(String.valueOf(studentId)))
                .statusCode(expectedCode.getStatusCode());
    }

    public ValidatableResponse updateStudent(int studentId, Student student, StatusCode expectedCode) {
        return sendPut(PUT_STUDENT.updateRequestUriWithParams(String.valueOf(studentId)), student)
                .statusCode(expectedCode.getStatusCode());
    }
}
