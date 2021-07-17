package com.studentapp.requests;

import com.framework.serenity.core.api.RequestBuilder;
import com.studentapp.data.model.Student;
import io.restassured.response.ValidatableResponse;

import static com.studentapp.constants.enums.StudentAppRequestURIs.*;


/**
 * @author trantrongnhan
 * <p>
 * Class implementation for all single api requests basing on Swagger or any api documentation
 */
public class StudentAppRequests extends RequestBuilder {

    /**
     * Constructor to init StudentAppRequests
     *
     * @param baseUri String
     */
    public StudentAppRequests(String baseUri) {
        super(baseUri);
    }

    /**
     * Send GET "/list" api request
     *
     * @return ValidatableResponse
     */
    public ValidatableResponse getStudentsList() {
        return sendGet(GET_STUDENTS_LIST);
    }

    /**
     * Send POST "/" api request
     *
     * @param student Student object which will be converted to JSON request body
     * @return ValidatableResponse
     */
    public ValidatableResponse createStudent(Student student) {
        return sendPost(POST_STUDENT, student);
    }

    /**
     * Send DELETE "/{StudentId}" api request
     *
     * @param studentId int Id of student to delete
     * @return ValidatableResponse
     */
    public ValidatableResponse deleteStudent(int studentId) {
        return sendDelete(DELETE_STUDENT, String.valueOf(studentId));
    }

    /**
     * Send GET "/{StudentId}" api request
     *
     * @param studentId int Id of student to retrieve
     * @return ValidatableResponse
     */
    public ValidatableResponse getStudentById(int studentId) {
        return sendGet(GET_STUDENT, String.valueOf(studentId));
    }


    /**
     * Send PUT "/{StudentId}" api request
     *
     * @param studentId id of student to update
     * @param student   student with new data which will be converted to JSON request body
     * @return ValidatableResponse
     */
    public ValidatableResponse updateStudent(int studentId, Student student) {
        return sendPut(PUT_STUDENT, student, String.valueOf(studentId));
    }
}
