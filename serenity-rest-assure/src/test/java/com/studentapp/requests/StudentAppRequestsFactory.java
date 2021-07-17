package com.studentapp.requests;


/**
 * @author trantrongnhan
 * <p>
 * Class implementation for initializing all api request classes
 */
public class StudentAppRequestsFactory {

    protected StudentAppRequests studentAppRequests;

    /**
     * Init all api request classes of Application Under Test
     *
     * @param baseUri String
     */
    public void initRequests(String baseUri) {
        studentAppRequests = new StudentAppRequests(baseUri);
    }

    /**
     * Get StudentAppRequests to invoke send request methods
     *
     * @return studentAppRequests StudentAppRequests
     */
    public StudentAppRequests getStudentAppRequests() {
        return studentAppRequests;
    }
}
