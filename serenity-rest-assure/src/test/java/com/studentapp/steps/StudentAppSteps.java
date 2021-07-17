package com.studentapp.steps;

import com.studentapp.data.model.Student;
import com.studentapp.response.CreatedUpdatedSuccess;
import com.studentapp.response.ErrorResponse;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

import java.util.List;


/**
 * @author trantrongnhan
 * <p>
 * Class implemenation for common functions which call api requests to conduct a business flow and including Response
 * validation and will be generated with Step Description in Report with @Step annotation
 */
public class StudentAppSteps extends BaseSteps {

    @Step("Get list of Students")
    public List<Student> getStudentsListSuccess() {
        return studentRequests.getStudentsList()
                .spec(studentResponseSpec.getStudentsListSuccessSpec())
                .extract().body().jsonPath().getList(".", Student.class);
    }

    @Step("Create new student: {0}")
    public CreatedUpdatedSuccess createStudentSuccess(Student student) {
        return studentRequests.createStudent(student)
                .spec(studentResponseSpec.createStudentSuccessSpec())
                .extract().as(CreatedUpdatedSuccess.class);
    }

    @Step("Delete student with id: {0}")
    public ValidatableResponse deleteStudentSuccess(int studentId) {
        return studentRequests.deleteStudent(studentId)
                .spec(studentResponseSpec.deleteStudentSuccessSpec());
    }

    @Step("Get existing student with id: {0}")
    public Student getExistingStudentById(int studentId) {
        return studentRequests.getStudentById(studentId)
                .spec(studentResponseSpec.getExistingStudentSuccessSpec())
                .extract().as(Student.class);
    }

    @Step("Get non-existing student with id: {0}")
    public ErrorResponse getNotExistingStudentById(int studentId) {
        return studentRequests.getStudentById(studentId)
                .spec(studentResponseSpec.getNotExistingStudentSpec())
                .extract().as(ErrorResponse.class);
    }

    @Step("Update student with id: {0} to {1}")
    public CreatedUpdatedSuccess updateStudentSuccess(int studentId, Student student) {
        return studentRequests.updateStudent(studentId, student)
                .spec(studentResponseSpec.updateStudentSuccessSpec())
                .extract().as(CreatedUpdatedSuccess.class);
    }

    @Step("Get Student id by email: '{0}'")
    public int getStudentIdByEmail(String email) {
        List<Student> students = getStudentsListSuccess();
        for (Student std : students) {
            if (std.getEmail().equals(email)) {
                return std.getId();
            }
        }
        return -1;
    }

    @Step("Delete student by email: '{0}'")
    public void deleteStudentByEmail(String email) {
        int studentId = getStudentIdByEmail(email);
        deleteStudentSuccess(studentId);
    }

    @Step("Get existing student by email: '{0}'")
    public Student getStudentByEmail(String email) {
        List<Student> students = getStudentsListSuccess();
        for (Student std : students) {
            if (std.getEmail().equals(email)) {
                return std;
            }
        }
        return null;
    }
}
