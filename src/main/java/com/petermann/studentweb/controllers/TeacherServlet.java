package com.petermann.studentweb.controllers;

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

    @Override
    public void doPut(HttpServletRequest request, HttpServletResponse response) {
        int index = Integer.parseInt(request.getParameter("update"));
        String newFirstName = request.getParameter("newFirstName");
        String newLastName = request.getParameter("newLastName");
        String newDepartment = request.getParameter("newDepartment");
        String newEmail = request.getParameter("newEmail");
        String newPhone = request.getParameter("newPhone");

        Teacher itemToUpdate = DataSource.getInstance().getTeacherArrayList().get(index);
        itemToUpdate.setFirstName(newFirstName);
        itemToUpdate.setLastName(newLastName);
        itemToUpdate.setDepartment(newDepartment);
        itemToUpdate.setEmail(newEmail);
        itemToUpdate.setPhone(newPhone);
    }

    public void destroy() { }
}