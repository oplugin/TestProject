package com.example.servletproject.samples;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "sum", value = "/sum")
public class SumServlet extends HttpServlet {

    private final SumService sumService = SumService.SUM_SERVICE;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

//        int number1 = Integer.parseInt(request.getParameter("number1"));
//        int number2 = Integer.parseInt(request.getParameter("number2"));
//
//
//
//        PrintWriter writer = response.getWriter();
//        int result = a + b;
//        writer.write("result = " + result);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int number1 = Integer.parseInt(req.getParameter("number1"));
        int number2 = Integer.parseInt(req.getParameter("number2"));

        int result = sumService.getResult(number1, number2);
        req.setAttribute("result", result);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/result.jsp");
        requestDispatcher.forward(req, resp);

    }
}
