package com.studentapp.requests;

import com.framework.serenity.core.api.RequestBuilder;
import com.studentapp.data.model.Student;
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

    public ValidatableResponse getStudentsList() {
        return sendGet(GET_STUDENTS_LIST);
    }

    public ValidatableResponse createStudent(Student student) {
        return sendPost(POST_STUDENT, student);
    }

    public ValidatableResponse deleteStudent(int studentId) {
        return sendDelete(DELETE_STUDENT, String.valueOf(studentId));
    }

    public ValidatableResponse getStudentById(int studentId) {
        return sendGet(GET_STUDENT, String.valueOf(studentId));
    }

    public ValidatableResponse updateStudent(int studentId, Student student) {
        return sendPut(PUT_STUDENT, student, String.valueOf(studentId));
    }
}
