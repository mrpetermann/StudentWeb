package com.petermann.studentweb;

import java.io.*;
import java.util.ArrayList;

import com.petermann.studentweb.dao.DataSource;
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
            request.getSession().setAttribute("teachers", DataSource.getInstance().getTeacherArrayList());

        RequestDispatcher view = request.getRequestDispatcher("teacher.jsp");
        view.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //Existing teacher list
        ArrayList<Teacher> teachers = DataSource.getInstance().getTeacherArrayList();

        //Construct new teacher from request
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        //Only create if any field contains a value
        if(!(firstName.equals("") && lastName.equals("") && department.equals("")
                && email.equals("") && phone.equals("")))
            teachers.add(new Teacher(firstName, lastName, email, phone, department));

        request.getSession().setAttribute("teachers", teachers);
        response.sendRedirect(request.getContextPath() + "/teacher");
    }

    @Override
    public void doDelete(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Teacher> teachers = DataSource.getInstance().getTeacherArrayList();

        teachers.remove(Integer.parseInt(request.getParameter("delete")));
        request.getSession().setAttribute("teachers", teachers);
    }

    public void destroy() { }
}