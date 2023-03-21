package com.example.servletproject.contoller;

import com.example.servletproject.config.Config;
import com.example.servletproject.config.FileResourcesUtils;
import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;
import com.example.servletproject.service.QuestionService;
import com.example.servletproject.util.Util;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    Collection<Question> questions = new ArrayList<>();
    Collection<Answer> answers = new ArrayList<>();
    Util util = new Util();

    public Long currentQuestionId = 1L;
    public Long nextQuestionId = 0L;
    public Long chosenAnswerId = 0L;

    QuestionService questionService = new QuestionService();

    @SneakyThrows
    public void init() throws ServletException {

        String fileSep = System.getProperty("file.separator");
        String dir= getServletContext().getRealPath("/");
        String questionFile=dir + "WEB-INF" + fileSep + "json" + fileSep + "questions.json";
        String answerFile=dir + "WEB-INF" + fileSep + "json" + fileSep + "answers.json";

        Config configParcer = new Config();
        questions = configParcer.jsonQuestionArrayParser(questionFile);
        answers = configParcer.jsonAnswerArrayParser(answerFile);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Question question = questionService.getQuestion(request, questions, answers);//getQuestion(request);
        request.setAttribute("question", question);

        List<Answer> answerList = answers.stream()
                .filter(answer -> answer.getQuestionId() == question.getId())
                .collect(Collectors.toList());

        request.setAttribute("answerList", answerList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userAnswer = request.getParameter("userAnswer");
        System.out.println("DO POST: User Answer " + userAnswer);

        Long nextQuestionByAnswerId = util.findNextQuestionByAnswerId(userAnswer, answers);
//        nextQuestionId = nextQuestionByAnswerId;
        questionService.nextQuestionId = nextQuestionByAnswerId;

        /**
         * Experiments with JSP
         *

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
         */
//        Answer answer = getAnswer(request);
        response.sendRedirect(String.format("%s?id=%d", "/game", nextQuestionByAnswerId));

    }

    public Question getQuestion(HttpServletRequest request) {//TODO перенести в Сервисы

        Long questionId;

        if (nextQuestionId == 0L) {
            questionId = 1L;
        } else{
            questionId = Long.parseLong(request.getParameter("id"));
        }

        System.out.println("DO GET: GET QUESTION: Q.ID: " + questionId);

        String questionText = questions.stream()
                .filter(q -> q.getId().equals(questionId))
                .map(question -> question.getText())
                .collect(Collectors.toList())
                .toString();

        String gameState = questions.stream()
                .filter(q -> q.getId().equals(questionId))
                .map(Question::getGameState).toList()
                .toString();

        String questionGameState = gameState.replaceAll("[\\[\\](){}]", "");

        Question question = Question
                .builder()
                .id(questionId)
                .text(questionText)
                .gameState(GameState.valueOf(questionGameState))
                .build();

        List<Answer> answerList = answers.stream()
                .filter(answer -> answer.getQuestionId() == questionId)
                .collect(Collectors.toList());

        for (Answer answer : answerList) {
            question.getAnswers().add(answer);
        }

        return question;
    }
}
