package com.studentapp.tests.editStudent;

import com.studentapp.data.model.Student;
import com.studentapp.tests.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class EditStudentTest extends TestBase {

    Student student = dataFactory.defaultNewStudent();
    Student updatedStudent = dataFactory.defaultUpdatedStudent(student);

    @Before
    public void beforeTest() {
        studentAppSteps.createStudentSuccess(student);
    }

    @After
    public void afterTest() {
        studentAppSteps.deleteStudentSuccess(updatedStudent.getId());
    }

    @Title("Validate that user can update an existing student")
    @Test
    public void validateUpdateExistingStudentSuccessfully() {
        int studentId = studentAppSteps.getStudentIdByEmail(student.getEmail());
        studentAppSteps.updateStudentSuccess(studentId, student);

        Student updatedStudent = studentAppSteps.getExistingStudentById(studentId);

        student.setId(studentId);
        validations.validateEqual(updatedStudent.toString(), student.toString(),
                "Validate information of the updated student should be correct");
    }
}

