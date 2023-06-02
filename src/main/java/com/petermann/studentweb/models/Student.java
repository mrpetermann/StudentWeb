package com.petermann.studentweb.models;

public class Student extends Person {
    private String grade;

    public Student(String firstName, String lastName, String email, String phone, String grade) {
        super(firstName, lastName, email, phone);
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
