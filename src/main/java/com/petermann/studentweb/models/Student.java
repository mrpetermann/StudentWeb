package com.petermann.studentweb.models;

public class Student extends Person {
    private int grade;

    public Student(String firstName, String lastName, String email, String phone, int grade) {
        super(firstName, lastName, email, phone);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
