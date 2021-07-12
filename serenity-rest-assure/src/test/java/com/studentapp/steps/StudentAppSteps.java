package com.studentapp.steps;

import com.framework.serenity.core.enums.StatusCode;
import com.studentapp.model.Student;
import com.studentapp.requests.StudentAppRequests;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

import static com.studentapp.tests.TestBase.requestsFactory;


/**
 * Creator: Nhan.Tran Trong
 * This class defines common functions which call api requests to conduct a business flow or need to
 * extract or handle some api request response and will be generated with Step Description in Report
 */
public class StudentAppSteps {
    // Init necessary Requests to be called
    private StudentAppRequests studentRequests = requestsFactory.getStudentAppRequests();

    @Step("Get list of Students")
    public ValidatableResponse getStudentsList(StatusCode expectedCode) {
        return studentRequests.getStudentsList(expectedCode);
    }

    @Step("Create new student: firstName='{0}'")
    public ValidatableResponse createStudent(Student student, StatusCode expectedCode) {
        return studentRequests.createStudent(student, expectedCode);
    }

    @Step("Delete student with id: {0}")
    public ValidatableResponse deleteStudent(int studentId, StatusCode expectedCode) {
        return studentRequests.deleteStudent(studentId, expectedCode);
    }

    @Step("Get student with id: {0}")
    public ValidatableResponse getStudentById(int studentId, StatusCode expectedCode) {
        return studentRequests.getStudentById(studentId, expectedCode);
    }

    @Step("Update student with id: {0} to {1}")
    public ValidatableResponse updateStudent(int studentId, Student student, StatusCode expectedCode) {
        return studentRequests.updateStudent(studentId, student, expectedCode);
    }

    @Step("Get Student id by email: '{0}'")
    public int getStudentIdByEmail(String email) {
        String findStudentByEmailPath = "findAll{it.email=='%s'}";
        String findPath = String.format(findStudentByEmailPath, email);
        List<HashMap<String, Object>> students = getStudentsList(StatusCode.SUCCESS)
                .extract()
                .path(findPath);

        if (students.size() > 0) {
            return (int) students.get(0).get("id");
        } else {
            return -1;
        }
    }
}
