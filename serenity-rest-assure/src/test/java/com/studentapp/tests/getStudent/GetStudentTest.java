package com.studentapp.tests.getStudent;

import com.studentapp.data.model.Student;
import com.studentapp.tests.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(SerenityRunner.class)
public class GetStudentTest extends TestBase {

    @Title("Validate that user can get list of existing students")
    @Test
    public void validateGetExistingStudents() {
        List<Student> response = studentAppSteps.getStudentsListSuccess();
        validations.validateGreaterThan(response.size(), 0,
                "Validate list of existing student should be returned correctly");
    }
}

