package com.studentapp.steps;

import com.studentapp.requests.StudentAppRequests;
import com.studentapp.steps.specifications.StudentAppResponseSpec;

import static com.studentapp.tests.TestBase.requestsFactory;


/**
 * @author trantrongnhan
 */
public class BaseSteps {

    // Init necessary Requests to be called
    protected StudentAppRequests studentRequests = requestsFactory.getStudentAppRequests();
    protected StudentAppResponseSpec studentResponseSpec = new StudentAppResponseSpec();
}
