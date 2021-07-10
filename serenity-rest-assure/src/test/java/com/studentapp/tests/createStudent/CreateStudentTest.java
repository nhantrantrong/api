package com.studentapp.tests.createStudent;

import com.studentapp.model.Student;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.constants.enums.StatusCode.*;
import static com.studentapp.requests.StudentAppRequestsFactory.studentRequests;

@RunWith(SerenityRunner.class)
public class CreateStudentTest extends TestBase {
    private final String firstName = "Karson";
    private final String lastName = "Tran";
    private final String programme = "ComputerScience";
    private final String email = String.format("KarsonTran_%s@gmail.com", TestUtils.getRandomValue());
    private final List<String> courses = new ArrayList<>();

    @After
    public void afterTest() {
        int studentId = studentAppBusiness.getStudentIdByEmail(email);
        studentRequests.deleteStudent(studentId, NO_CONTENT);
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

        studentRequests.createStudent(student, CREATED);
    }
}
