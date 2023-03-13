package com.example.servletproject.contoller;

import com.example.servletproject.entity.Question;
import com.example.servletproject.samples.Book;
import com.example.servletproject.service.QuestionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;


@WebServlet(name = "QuestionServlet", value = "/question")
public class QuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Question question = getQuestion(request);
        String questionId = request.getParameter("id");




        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/questionform.jsp");
        dispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

//    private Question getQuestion(HttpServletRequest req) {
//        return Optional.ofNullable(req.getParameter("id"))
//                .map(Long::valueOf)
//                .flatMap(questions.getId)
//                .orElse(null);
//    }
}
