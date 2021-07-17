package com.studentapp.tests.deleteStudent;

import com.studentapp.data.model.Student;
import com.studentapp.tests.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(SerenityRunner.class)
public class DeleteStudentTest extends TestBase {

    Student student = dataFactory.defaultNewStudent();

    @Before
    public void beforeTest() {
        studentAppSteps.createStudentSuccess(student);
    }

    @Title("Validate that user can delete an existing student")
    @Test
    public void validateDeleteExistingStudentSuccessfully() {
        studentAppSteps.deleteStudentByEmail(student.getEmail());

        Student deletedStudent = studentAppSteps.getStudentByEmail(student.getEmail());
        validations.validateNull(deletedStudent,
                "Validate deleted student should be removed from list");
    }
}

