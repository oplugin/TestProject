package com.example.servletproject.contoller;

import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.Question;
import com.example.servletproject.repository.QuestionRepository;
import com.example.servletproject.service.QuestionService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.Objects;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
