package com.example.servletproject.contoller;

import com.example.servletproject.config.Config;
import com.example.servletproject.config.FileResourcesUtils;
import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;
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


    @SneakyThrows
    public void init() throws ServletException {

        String fileSep = System.getProperty("file.separator");
        String dir= getServletContext().getRealPath("/");
        String file=dir + "WEB-INF" + fileSep + "json" + fileSep + "questions.json";

        Config configParcer = new Config();
        questions = configParcer.jsonQuestionArrayParser(file);

        Answer answer1 = new Answer(1L, "Принять вызов", 1L, 2L);
        Answer answer2 = new Answer(2L, "Отклонить вызов", 1L, 5L);
//        Question question5 = new Question(5L, "Ты отклонил вызов. Поражение", GameState.LOST);

//        Question question2 = new Question(2L, "Ты принял вызов. Поднимаешься на мостик к капитану", GameState.PLAY);

        Answer answer3 = new Answer(3L, "Подняться на мостик", 2L, 3L);
        Answer answer4 = new Answer(4L, "Отказаться подниматься на мостик", 2L, 6L);
//        Question question6 = new Question(6L, "Ты не пошел на переговоры. Поражение", GameState.LOST);

//        Question question3 = new Question(3L, "Ты поднимаешься на мостик. Ты кто ?", GameState.PLAY);

        Answer answer5 = new Answer(5L, "Рассказать правду о себе", 3L, 4L);
        Answer answer6 = new Answer(6L, "Солгать о себе", 3L, 5L);
//        Question question7 = new Question(7L, "Твоя ложь разоблачена. Поражение", GameState.LOST);

//        Question question4 = new Question(4L, "Ты вернулся домой. Победа", GameState.WIN);

//        questions.add(question1);
//        questions.add(question2);
//        questions.add(question3);
//        questions.add(question4);
//        questions.add(question5);
//        questions.add(question6);
//        questions.add(question7);

        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);

    }



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        // TODO Find question by First Question ID
        // Question.ID
        Question question = getQuestion(request);
        request.setAttribute("question", question);



        // TODO Provide request with AnswerList according current QuestionID
        // AnswerList
        // Answer.ID
        // Answer.TEXT
        List<Answer> answerList = answers.stream()
                .filter(answer -> answer.getQuestionId() == question.getId())
                .collect(Collectors.toList());

        request.setAttribute("answerList", answerList);

//
//        String questionId = request.getParameter("id");
//        System.out.println(questionId);
//
//        Long currentQuestionId = util.currentQuestionId;
//        request.setAttribute("questionId", currentQuestionId);
//
//        List<String> answersByQuestionId = util.getAnswersByQuestionId(answers, questionId);
//        request.setAttribute("answer", answersByQuestionId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/game.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userAnswer = request.getParameter("userAnswer");
        System.out.println("DO POST: User Answer " + userAnswer);

        Long nextQuestionByAnswerId = util.findNextQuestionByAnswerId(userAnswer, answers);
        nextQuestionId = nextQuestionByAnswerId;
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

    public Question getQuestion(HttpServletRequest request) {

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
