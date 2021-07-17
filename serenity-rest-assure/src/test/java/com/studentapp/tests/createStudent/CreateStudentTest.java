package com.studentapp.tests.createStudent;

import com.studentapp.data.model.Student;
import com.studentapp.tests.TestBase;
import com.framework.serenity.core.utils.Numbers;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CreateStudentTest extends TestBase {

    Student student = dataFactory.defaultNewStudent();

    @After
    public void afterTest() {
        studentAppSteps.deleteStudentByEmail(student.getEmail());
    }

    @Title("Validate new student can be created successfully")
    @Test
    public void validateCreateStudentSuccessfully() {
        studentAppSteps.createStudentSuccess(student);
        Student createdStudent = studentAppSteps.getStudentByEmail(student.getEmail());
        student.setId(createdStudent.getId());
        validations.validateEqual(createdStudent.toString(), student.toString(),
                "Validate the student should be created successfully");

    }
}
