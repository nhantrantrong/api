package com.studentapp.data.model;

import java.util.List;

/**
 * @author trantrongnhan
 * @implNote This class could be considered to be deprecated when apply DTO for enhancement
 * <p>
 * Class implementation for model entities, which can be treated as a Test Data or convert to JSON Body / Response while
 * executing test
 */
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    /**
     * Get id of Student
     *
     * @return id int
     */
    public int getId() {
        return id;
    }

    /**
     * Set id for Student
     *
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get firstName of Student
     *
     * @return firstName String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set firstName for Student
     *
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get lastName of Student
     *
     * @return lastName String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set lastName for Student
     *
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get email of Student
     *
     * @return email String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email for Student
     *
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get programme of Student
     *
     * @return programme String
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * Set programme for Student
     *
     * @param programme String
     */
    public void setProgramme(String programme) {
        this.programme = programme;
    }

    /**
     * Get courses of Student
     *
     * @return courses List<String>
     */
    public List<String> getCourses() {
        return courses;
    }

    /**
     * Set courses for Student
     *
     * @param courses List<String>
     */
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        String student = String.format(
                "{id=%s, firstName='%s', lastName='%s', email='%s', programme='%s', courses:%s}",
                getId(), getFirstName(), getLastName(), getEmail(), getProgramme(),
                getCourses().toString());
        return student;
    }
}
