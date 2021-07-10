package com.studentapp.requests.business;

import com.framework.serenity.core.enums.StatusCode;

import java.util.HashMap;
import java.util.List;

import static com.studentapp.requests.StudentAppRequestsFactory.studentRequests;

/**
 * Creator: Nhan.Tran Trong
 * This class defines common functions which call multiple single api requests to conduct a business flow or need to
 * extract or handle some api request response
 *
 */
public class StudentAppBusiness {

    public int getStudentIdByEmail(String email) {
        String findStudentByEmailPath = "findAll{it.email=='%s'}";
        String findPath = String.format(findStudentByEmailPath, email);
        List<HashMap<String, Object>> students = studentRequests.getStudentsList(StatusCode.SUCCESS)
                .extract()
                .path(findPath);

        if (students.size() > 0) {
            return (int) students.get(0).get("id");
        } else {
            return -1;
        }
    }
}
