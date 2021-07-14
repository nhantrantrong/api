package com.studentapp.tests.createStudent;

import com.studentapp.model.Student;
import com.studentapp.tests.TestBase;
import com.framework.serenity.core.utils.Numbers;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(SerenityRunner.class)
public class CreateStudentTest extends TestBase {
    private final String firstName = "Karson";
    private final String lastName = "Tran";
    private final String programme = "ComputerScience";
    private final String email = String.format("KarsonTran_%s@gmail.com", Numbers.getRandomInt());
    private final List<String> courses = new ArrayList<>();

    @After
    public void afterTest() {
        int studentId = studentAppSteps.getStudentIdByEmail(email);
        studentAppSteps.deleteStudentSuccess(studentId);
    }

    @Title("Validate new student can be created successfully")
    @Test
    public void validateCreateStudentSuccessfully() {
        courses.add("JAVA");
        courses.add("Selenium");

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setProgramme(programme);
        student.setCourses(courses);

        studentAppSteps.createStudentSuccess(student);
        int studentId = studentAppSteps.getStudentIdByEmail(email);
        Student createdStudent = studentAppSteps.getExistingStudentById(studentId);
        student.setId(studentId);
        validations.validateEqual(createdStudent.toString(), student.toString(),
                "Validate the student should be created successfully");

    }
}
