package com.studentapp.data;

import com.framework.serenity.core.utils.Numbers;
import com.studentapp.data.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataFactory {
    private final String defaultFirstName = "Karson";
    private final String defaultLastName = "Tran";
    private final String defaultProgramme = "ComputerScience";
    private final String defaultEmail = String.format("KarsonTran_%s@gmail.com", Numbers.getRandomInt());
    private final List<String> defaultCourses = Arrays.asList("Java", "Selenium");

    public Student defaultNewStudent() {
        Student student = new Student();
        student.setFirstName(defaultFirstName);
        student.setLastName(defaultLastName);
        student.setEmail(defaultEmail);
        student.setProgramme(defaultProgramme);
        student.setCourses(defaultCourses);
        return student;
    }

    public Student defaultUpdatedStudent(Student originalStudent) {
        String updatedProgramme = "Automation Testing";
        List<String> updatedCourse = new ArrayList<>();
        for (String course : defaultCourses) {
            updatedCourse.add(course);
        }
        updatedCourse.add("API Testing");
        originalStudent.setFirstName(String.format("%s-Updated", originalStudent.getFirstName()));
        originalStudent.setLastName(String.format("%s-Updated", originalStudent.getLastName()));
        originalStudent.setProgramme(updatedProgramme);
        originalStudent.setCourses(updatedCourse);
        return originalStudent;
    }
}
