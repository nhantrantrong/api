package com.studentapp.tests.getStudent;

import com.studentapp.model.Student;
import com.studentapp.tests.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class GetStudentTest extends TestBase {

    @Title("Validate that user can get list of existing students")
    @Test
    public void validateGetExistingStudents() {
        Student[] response = studentAppSteps.getStudentsListSuccess();
        validations.validateGreaterThan(response.length, 0,
                "Validate list of existing student should be returned correctly");
    }
}

