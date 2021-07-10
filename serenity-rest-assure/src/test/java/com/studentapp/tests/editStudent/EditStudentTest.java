package com.studentapp.tests.editStudent;

import com.studentapp.model.Student;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.TestUtils;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.studentapp.constants.enums.StatusCode.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SerenityRunner.class)
public class EditStudentTest extends TestBase {

    private String firstName = "Karson";
    private String lastName = "Tran";
    private String programme = "ComputerScience";
    private String email = String.format("KarsonTran_%s@gmail.com", TestUtils.getRandomValue());
    private List<String> courses = new ArrayList<String>();
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

        studentRequests.createStudent(student, CREATED);
        studentId = studentRequests.getStudentIdByEmail(email);
    }

    @After
    public void afterTest() {
        studentRequests.deleteStudent(studentId, NO_CONTENT);
    }

    @Title("Validate that user can update an existing student")
    @Test
    public void validateUpdateExistingStudentSuccessfully() {
        courses.add("Design Pattern");
        String updatedFirstName = firstName + "-Updated";
        student.setFirstName(updatedFirstName);
        student.setCourses(courses);

        studentRequests.updateStudent(studentId, student, SUCCESS);

        HashMap<String, Object> updatedStudent = studentRequests.getStudentById(studentId, SUCCESS)
                .extract()
                .as(HashMap.class);

        String updatedStudentId = String.format("%.0f", Double.parseDouble(updatedStudent.get("id").toString()));
        assertThat(updatedStudentId, is(String.valueOf(studentId)));
        assertThat(updatedStudent, hasValue(student.getFirstName()));
        assertThat(updatedStudent, hasValue(student.getLastName()));
        assertThat(updatedStudent, hasValue(student.getEmail()));
        assertThat(updatedStudent, hasValue(student.getProgramme()));
        assertThat(updatedStudent, hasValue(student.getCourses()));
    }
}

