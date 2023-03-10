package com.example.servletproject;

import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;
import com.example.servletproject.util.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

    Long currentQuestionId = 1L;

    public static void main(String[] args) throws IOException {


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

        Collection<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);
        questions.add(question6);
        questions.add(question7);

        Collection<Answer> answers = new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        answers.add(answer5);
        answers.add(answer6);

        Util util = new Util();
        util.printQuestionAndAnswer(questions, answers);
        util.userChoice(answers);
        Long nextQuestionByAnswerId = util.findNextQuestionByAnswerId(answers);
        System.out.println("Next QuestionID is : " +  nextQuestionByAnswerId);

        util.printQuestionAndAnswer(questions, answers);
        util.userChoice(answers);
        util.findNextQuestionByAnswerId(answers);

        util.printQuestionAndAnswer(questions, answers);
        util.userChoice(answers);
        util.findNextQuestionByAnswerId(answers);

        util.printQuestionAndAnswer(questions, answers);
        util.userChoice(answers);
        util.findNextQuestionByAnswerId(answers);

    }
}
