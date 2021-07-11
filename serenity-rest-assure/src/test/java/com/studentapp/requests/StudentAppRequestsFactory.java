package com.studentapp.requests;

import com.framework.serenity.core.api.RequestBuilder;
import com.studentapp.requests.business.StudentAppBusiness;
import com.studentapp.requests.original.StudentAppRequests;
import net.thucydides.core.annotations.Steps;

/**
 * Creator: Nhan.Tran Trong
 * This class is used to initialize all api and business requests classes
 *
 */
public class StudentAppRequestsFactory  {

    public static RequestBuilder requestBuilder;

    @Steps
    public static StudentAppBusiness studentAppBusiness;

    @Steps
    public static StudentAppRequests studentRequests;

    public static void initRequests(String baseUri){
        requestBuilder = new RequestBuilder(baseUri);
    }
}
