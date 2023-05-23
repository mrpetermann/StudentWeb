package com.petermann.studentweb;

import java.io.*;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "teacherServlet", value = "/teacher")
public class TeacherServlet extends HttpServlet {
    public void init() { }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getSession().getAttribute("words") == null)
            request.getSession().setAttribute("words", new ArrayList<String>());

        RequestDispatcher view = request.getRequestDispatcher("teacher.jsp");
        view.forward(request, response);
    }

    @Override @SuppressWarnings("unchecked")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ArrayList<String> words = (ArrayList<String>)request.getSession().getAttribute("words");
        words.add(request.getParameter("newWord"));
        request.getSession().setAttribute("words", words);

        doGet(request, response);
    }

    public void destroy() { }
}