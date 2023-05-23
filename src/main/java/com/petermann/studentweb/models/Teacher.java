package com.petermann.studentweb.models;

public class Teacher extends Person {
    private String department;

    public Teacher(String firstName, String lastName, String email, String phone, String department) {
        super(firstName, lastName, email, phone);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
