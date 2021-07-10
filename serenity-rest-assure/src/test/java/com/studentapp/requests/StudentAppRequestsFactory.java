package com.studentapp.requests;

import com.studentapp.requests.business.StudentAppBusiness;
import com.studentapp.requests.original.StudentAppRequests;

/**
 * Creator: Nhan.Tran Trong
 * This class is used to initialize all api and business requests classes
 *
 */
public class StudentAppRequestsFactory  {
    public static StudentAppRequests studentRequests;
    public static StudentAppBusiness studentAppBusiness;

    public static void initRequests(String baseUri){
        // init original single api requests
        studentRequests = new StudentAppRequests(baseUri);

        // init business class which contains multiple api request for a business flow
        studentAppBusiness = new StudentAppBusiness();
    }
}
