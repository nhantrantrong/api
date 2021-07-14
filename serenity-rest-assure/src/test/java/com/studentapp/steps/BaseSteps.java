package com.studentapp.steps;

import com.framework.serenity.core.enums.StatusCode;
import com.studentapp.model.Student;
import com.studentapp.requests.StudentAppRequests;
import com.studentapp.response.CreatedUpdatedSuccess;
import com.studentapp.steps.specifications.StudentAppResponseSpec;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Step;

import static com.framework.serenity.core.enums.StatusCode.CREATED;
import static com.framework.serenity.core.enums.StatusCode.SUCCESS;
import static com.studentapp.tests.TestBase.requestsFactory;


/**
 * @author trantrongnhan
 */
public class BaseSteps {
    // Init necessary Requests to be called
    protected StudentAppRequests studentRequests = requestsFactory.getStudentAppRequests();
    protected StudentAppResponseSpec studentResponseSpec = new StudentAppResponseSpec();

    @Step("{0}")
    public void logSteps(String stepDefinition) {
        System.out.println(String.format("[Step] %s", stepDefinition));
    }

}
