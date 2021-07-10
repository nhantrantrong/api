package com.studentapp.tests.deleteStudent;

import com.studentapp.model.Student;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import static com.studentapp.constants.enums.StatusCode.*;

@RunWith(SerenityRunner.class)
public class DeleteStudentTest extends TestBase {

    private final String firstName = "Karson";
    private final String lastName = "Tran";
    private final String programme = "ComputerScience";
    private final String email = String.format("KarsonTran_%s@gmail.com", TestUtils.getRandomValue());
    private final List<String> courses = new ArrayList<String>();

    @Before
    public void beforeTest() {
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

    @Title("Validate that user can delete an existing student")
    @Test
    public void validateDeleteExistingStudentSuccessfully() {
        int studentId = studentAppBusiness.getStudentIdByEmail(email);
        studentRequests.deleteStudent(studentId, NO_CONTENT);
        studentRequests.getStudentById(studentId, NOT_FOUND);
    }
}

