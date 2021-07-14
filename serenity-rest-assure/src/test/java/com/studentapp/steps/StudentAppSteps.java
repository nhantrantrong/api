package com.studentapp.steps;

import com.framework.serenity.core.enums.StatusCode;
import com.studentapp.model.Student;
import com.studentapp.response.CreatedUpdatedSuccess;
import com.studentapp.response.ErrorResponse;
import io.restassured.response.ValidatableResponse;
import static com.framework.serenity.core.enums.StatusCode.*;


/**
 * Creator: Nhan.Tran Trong
 * This class defines common functions which call api requests to conduct a business flow or need to
 * extract or handle some api request response and will be generated with Step Description in Report
 */
public class StudentAppSteps extends BaseSteps {

    public Student[] getStudentsListSuccess() {
        logSteps("Get list of Students");
        return studentRequests.getStudentsList()
                .spec(studentResponseSpec.getStudentsListSuccessSpec())
                .extract().as(Student[].class);
    }

    public CreatedUpdatedSuccess createStudentSuccess(Student student) {
        logSteps(String.format("Create new student: '%s'", student.toString()));
        return studentRequests.createStudent(student)
                .spec(studentResponseSpec.createStudentSuccessSpec())
                .extract().as(CreatedUpdatedSuccess.class);
    }

    public ValidatableResponse deleteStudentSuccess(int studentId) {
        logSteps(String.format("Delete student with id: %s", String.valueOf(studentId)));
        return studentRequests.deleteStudent(studentId)
                .spec(studentResponseSpec.deleteStudentSuccessSpec());
    }

    public Student getExistingStudentById(int studentId) {
        logSteps(String.format("Get existing student with id: %s", String.valueOf(studentId)));
        return studentRequests.getStudentById(studentId)
                .spec(studentResponseSpec.getExistingStudentSuccessSpec())
                .extract().as(Student.class);
    }

    public ErrorResponse getNotExistingStudentById(int studentId) {
        logSteps(String.format("Get existing student with id: %s", String.valueOf(studentId)));
        return studentRequests.getStudentById(studentId)
                .spec(studentResponseSpec.getNotExistingStudentSpec())
                .extract().as(ErrorResponse.class);
    }

    public CreatedUpdatedSuccess updateStudentSuccess(int studentId, Student student) {
        logSteps(String.format("Update student with id: %s to %s",
                        String.valueOf(studentId), student.toString()));
        return studentRequests.updateStudent(studentId, student)
                .spec(studentResponseSpec.updateStudentSuccessSpec())
                .extract().as(CreatedUpdatedSuccess.class);
    }

    public int getStudentIdByEmail(String email) {
        logSteps(String.format("Get Student id by email: '%s'", email));
        Student[] students = getStudentsListSuccess();
        for (Student std : students) {
            if (std.getEmail().equals(email)) {
                return std.getId();
            }
        }
        return -1;
    }
}
