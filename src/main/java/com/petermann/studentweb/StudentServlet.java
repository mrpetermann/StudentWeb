package com.petermann.studentweb;

import java.io.*;
import java.util.ArrayList;

import com.petermann.studentweb.dao.DataSource;
import com.petermann.studentweb.models.Student;
import com.petermann.studentweb.models.Teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    public void init() { }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("students") == null)
            request.getSession().setAttribute("students", DataSource.getInstance().getStudentArrayList());

        RequestDispatcher view = request.getRequestDispatcher("student.jsp");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Existing teacher list
        ArrayList<Student> students = DataSource.getInstance().getStudentArrayList();

        //Construct new teacher from request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        //Get grade or default to 1
        int grade;
        try {
            grade = Integer.parseInt(request.getParameter("grade"));
        } catch(Exception e) {
            grade = 1;
        }

        //Only create if any field contains a value
        if(!(firstName.equals("") && lastName.equals("")
                && email.equals("") && phone.equals("")))
            students.add(new Student(firstName, lastName, email, phone, grade));

        request.getSession().setAttribute("students", students);
        doGet(request, response);
    }

    public void destroy() { }
}