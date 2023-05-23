package com.petermann.studentweb;

import java.io.*;
import java.util.ArrayList;

import com.petermann.studentweb.models.Teacher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "teacherServlet", value = "/teacher")
public class TeacherServlet extends HttpServlet {
    public void init() { }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("teachers") == null)
            request.getSession().setAttribute("teachers", new ArrayList<Teacher>());

        RequestDispatcher view = request.getRequestDispatcher("teacher.jsp");
        view.forward(request, response);
    }

    @Override @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<Teacher> teachers = (ArrayList<Teacher>)request.getSession().getAttribute("teachers");

        //Construct new teacher from request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if(!(firstName.equals("") && lastName.equals("") && department.equals("")
                && email.equals("") && phone.equals("")))
            teachers.add(new Teacher(firstName, lastName, email, phone, department));

        request.getSession().setAttribute("teachers", teachers);
        doGet(request, response);
    }

    public void destroy() { }
}