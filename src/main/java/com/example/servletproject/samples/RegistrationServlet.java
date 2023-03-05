package com.example.servletproject.samples;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", value = "/register")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/samples/register.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        if (email == null || name == null || age == null || password == null || confirmPassword == null) {
            request.setAttribute("error", "You are missing of the inputs");
            doGet(request, response);
        } else {
            if (!password.equalsIgnoreCase(confirmPassword)) {
                request.setAttribute("error", "The password do not match.");
                doGet(request, response);
            } else {
                System.out.println("The account has been created!");
            }
        }
    }
}
