package com.studentapp.steps;

import com.studentapp.requests.StudentAppRequests;
import com.studentapp.steps.specifications.StudentAppResponseSpec;

import static com.studentapp.tests.TestBase.requestsFactory;


/**
 * @author trantrongnhan
 * <p>
 * Class implementation for initializing all api requests and Response Specificaiton Classes which are invoked in
 * Steps class
 */
public class BaseSteps {

    // Init necessary Requests to be called
    protected StudentAppRequests studentRequests = requestsFactory.getStudentAppRequests();
    protected StudentAppResponseSpec studentResponseSpec = new StudentAppResponseSpec();
}
