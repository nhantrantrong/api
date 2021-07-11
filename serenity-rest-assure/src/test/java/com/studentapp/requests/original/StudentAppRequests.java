package com.studentapp.requests.original;

import com.framework.serenity.core.enums.StatusCode;
import com.studentapp.model.Student;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

import static com.studentapp.constants.enums.StudentAppRequestURIs.*;
import static com.studentapp.requests.StudentAppRequestsFactory.requestBuilder;


/**
 * Creator: Nhan.Tran Trong
 * This class implements all single api request basing on Swagger or any api documentation
 */
public class StudentAppRequests {

    @Step("Get list of Students")
    public ValidatableResponse getStudentsList(StatusCode expectedCode) {
        return requestBuilder.sendGet(GET_STUDENTS_LIST)
                .statusCode(expectedCode.getStatusCode());
    }

    @Step("Create new student: firstName='{0}'")
    public ValidatableResponse createStudent(Student student, StatusCode expectedCode) {
        return requestBuilder.sendPost(POST_STUDENT, student)
                .statusCode(expectedCode.getStatusCode());
    }

    @Step("Delete student with id: {0}")
    public ValidatableResponse deleteStudent(int studentId, StatusCode expectedCode) {
        return requestBuilder.sendDelete(DELETE_STUDENT, String.valueOf(studentId))
                .statusCode(expectedCode.getStatusCode());
    }

    @Step("Get student with id: {0}")
    public ValidatableResponse getStudentById(int studentId, StatusCode expectedCode) {
        return requestBuilder.sendGet(GET_STUDENT, String.valueOf(studentId))
                .statusCode(expectedCode.getStatusCode());
    }

    @Step("Update student with id: {0} to {1}")
    public ValidatableResponse updateStudent(int studentId, Student student, StatusCode expectedCode) {
        return requestBuilder.sendPut(PUT_STUDENT, student, String.valueOf(studentId))
                .statusCode(expectedCode.getStatusCode());
    }
}
