package com.studentapp.requests;


/**
 * Creator: Nhan.Tran Trong
 * This class is used to initialize all api and business requests classes
 */
public class StudentAppRequestsFactory {

    public StudentAppRequests studentAppRequests;

    public void initRequests(String baseUri) {
        studentAppRequests = new StudentAppRequests(baseUri);
    }

    public StudentAppRequests getStudentAppRequests() {
        return studentAppRequests;
    }
}
