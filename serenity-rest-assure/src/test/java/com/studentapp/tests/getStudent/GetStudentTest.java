package com.studentapp.tests.getStudent;

import com.studentapp.tests.TestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.framework.serenity.core.enums.StatusCode.*;

@RunWith(SerenityRunner.class)
public class GetStudentTest extends TestBase {

    @Title("Validate that user can get list of existing students")
    @Test
    public void validateGetExistingStudents() {
        studentAppSteps.getStudentsList(SUCCESS);
    }
}

