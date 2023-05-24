package com.petermann.studentweb.dao;

import com.petermann.studentweb.models.Teacher;

import java.util.ArrayList;

public class DataSource {
    private static DataSource dataSource;
    //private ArrayList<Student> studentArrayList;
    private ArrayList<Teacher> teacherArrayList;

    private DataSource() {
        //studentArrayList = new ArrayList<>();
        teacherArrayList = new ArrayList<>();
    }

    public static DataSource getInstance() {
        if(dataSource == null)
            dataSource = new DataSource();

        return dataSource;
    }

    /*
    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }
     */

    public ArrayList<Teacher> getTeacherArrayList() {
        return teacherArrayList;
    }
}
