package com.studentapp.tests.editStudent;

import com.studentapp.model.Student;
import com.studentapp.tests.TestBase;
import com.framework.serenity.core.utils.Numbers;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.framework.serenity.core.enums.StatusCode.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class EditStudentTest extends TestBase {

    private final String firstName = "Karson";
    private final String lastName = "Tran";
    private final String programme = "ComputerScience";
    private final String email = String.format("KarsonTran_%s@gmail.com", Numbers.getRandomInt());
    private final List<String> courses = new ArrayList<>();
    Student student = new Student();
    private int studentId;

    @Before
    public void beforeTest() {
        courses.add("JAVA");
        courses.add("Selenium");

        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        studentAppSteps.createStudentSuccess(student);
        studentId = studentAppSteps.getStudentIdByEmail(email);
    }

    @After
    public void afterTest() {
        studentAppSteps.deleteStudentSuccess(studentId);
    }

    @Title("Validate that user can update an existing student")
    @Test
    public void validateUpdateExistingStudentSuccessfully() {
        courses.add("Design Pattern");
        String updatedFirstName = firstName + "-Updated";
        student.setFirstName(updatedFirstName);
        student.setCourses(courses);

        studentAppSteps.updateStudentSuccess(studentId, student);

        Student updatedStudent = studentAppSteps.getExistingStudentById(studentId);

        student.setId(studentId);
        validations.validateEqual(updatedStudent.toString(), student.toString(),
                "Validate information of the updated student should be correct");
    }
}

