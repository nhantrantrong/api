package com.studentapp.requests;

import com.studentapp.constants.enums.StatusCode;

import java.util.HashMap;
import java.util.List;


public class StudentAppBusiness extends StudentAppRequests {

    public StudentAppBusiness(String baseUri) {
        super(baseUri);
    }

    public int getStudentIdByEmail(String email) {
        String findStudentByEmailPath = "findAll{it.email=='%s'}";
        String findPath = String.format(findStudentByEmailPath, email);
        List<HashMap<String, Object>> students = getStudentsList(StatusCode.SUCCESS)
                .extract()
                .path(findPath);

        if (students.size() > 0) {
            return (int) students.get(0).get("id");
        } else {
            return -1;
        }
    }
}
