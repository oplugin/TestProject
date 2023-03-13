package com.example.servletproject.contoller;

import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;
import com.example.servletproject.repository.QuestionRepository;
import com.example.servletproject.service.QuestionService;
import com.example.servletproject.util.Util;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    Collection<Question> questions = new ArrayList<>();
    Collection<Answer> answers = new ArrayList<>();
    Util util = new Util();

    public void init() throws ServletException {
        Question question1 = new Question(1L, "Ты потерял память. Принять вызов НЛО ?", GameState.PLAY);

        Answer answer1 = new Answer(1L, "Принять вызов", 1L, 2L);
        Answer answer2 = new Answer(2L, "Отклонить вызов", 1L, 5L);
        Question question5 = new Question(5L, "Ты отклонил вызов. Поражение", GameState.LOST);

        Question question2 = new Question(2L, "Ты принял вызов. Поднимаешься на мостик к капитану", GameState.PLAY);

        Answer answer3 = new Answer(3L, "Подняться на мостик", 2L, 3L);
        Answer answer4 = new Answer(4L, "Отказаться подниматься на мостик", 2L, 6L);
        Question question6 = new Question(6L, "Ты не пошел на переговоры. Поражение", GameState.LOST);

        Question question3 = new Question(3L, "Ты поднимаешься на мостик. Ты кто ?", GameState.PLAY);

        Answer answer5 = new Answer(5L, "Рассказать правду о себе", 3L, 4L);
        Answer answer6 = new Answer(6L, "Солгать о себе", 3L, 5L);
        Question question7 = new Question(7L, "Твоя ложь разоблачена. Поражение", GameState.LOST);

        Question question4 = new Question(4L, "Ты вернулся домой. Победа", GameState.WIN);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String questionText = util.finQuestionText(questions, answers);
        request.setAttribute("questionText", questionText);

        String questionId = request.getParameter("id");
        System.out.println(questionId);

        Long currentQuestionId = util.currentQuestionId;
        request.setAttribute("questionId", currentQuestionId);

        List<String> answersByQuestionId = util.getAnswersByQuestionId(answers, questionId);
        request.setAttribute("answer", answersByQuestionId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String answer = request.getParameter("answer");
        System.out.println("Answer: " + answer);

        String userChoice;
        if (answer.equals("answer-1")) {
            userChoice = "1";
            Long userJSPChoice = util.userJSPChoice(answers, userChoice);
            System.out.println(userJSPChoice);
        } else if (answer.equals("answer-2")) {
            userChoice = "2";
            Long userJSPChoice = util.userJSPChoice(answers, userChoice);
            System.out.println(userJSPChoice);
        }

//        Answer answer = getAnswer(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game.jsp");
        dispatcher.forward(request, response);
    }

}
