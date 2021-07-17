package com.studentapp.data;

import com.framework.serenity.core.utils.Numbers;
import com.studentapp.data.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author trantrongnhan
 * <p>
 * Class implementation for producing Test Data Object (ex: Student with some default value) to reduce duplciating
 * hard-codd value in Tests classes
 */
public class DataFactory {
    private final String defaultFirstName = "Karson";
    private final String defaultLastName = "Tran";
    private final String defaultProgramme = "ComputerScience";
    private final String defaultEmail = String.format("KarsonTran_%s@gmail.com", Numbers.getRandomInt());
    private final List<String> defaultCourses = Arrays.asList("Java", "Selenium");

    /**
     * Create a new Student Object with default value
     *
     * @return student Student
     */
    public Student defaultNewStudent() {
        Student student = new Student();
        student.setFirstName(defaultFirstName);
        student.setLastName(defaultLastName);
        student.setEmail(defaultEmail);
        student.setProgramme(defaultProgramme);
        student.setCourses(defaultCourses);
        return student;
    }

    /**
     * Generate an updated student object basing on the entered original Student data
     *
     * @param originalStudent Student
     * @return updatedStudent Student student object with updated test data
     */
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
