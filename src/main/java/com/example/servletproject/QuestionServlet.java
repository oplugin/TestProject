package com.example.servletproject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "QuestionServlet", value = "/questions")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/questionform.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String parameter = req.getParameter("textarea");
        String button = req.getParameter("button");
        PrintWriter writer = resp.getWriter();

        String uri = req.getRequestURI();
        System.out.println(uri);
        System.out.println(parameter);
        System.out.println(button);

        writer.write("URI is : " + uri);
        writer.write("\n");
        writer.write("Parameter is : " + parameter);
        writer.write("\n");
        writer.write("Button is : " + button);


        //http://localhost:8080/questions?textarea=test&button1id=
        //http://localhost:8080/questions?textarea=test2&button2id=

        /**
            int number1 = Integer.parseInt(req.getParameter("number1"));
            int number2 = Integer.parseInt(req.getParameter("number2"));

            int result = sumService.getResult(number1, number2);
            req.setAttribute("result", result);
        */

    }
}
