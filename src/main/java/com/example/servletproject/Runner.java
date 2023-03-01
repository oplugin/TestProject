package com.example.servletproject;

import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Runner {

    public static void main(String[] args) {

        Question question1 = new Question(1L, "Ты потерял память. Принять вызов НДО ?", GameState.PLAY);

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

        List<Question> questionCollection = new ArrayList<>();
        questionCollection.add(question1);
        questionCollection.add(question2);
        questionCollection.add(question3);
        questionCollection.add(question4);
        questionCollection.add(question5);
        questionCollection.add(question6);
        questionCollection.add(question7);

        List<Answer> answerCollection = new ArrayList<>();
        answerCollection.add(answer1);
        answerCollection.add(answer2);
        answerCollection.add(answer3);
        answerCollection.add(answer4);
        answerCollection.add(answer5);
        answerCollection.add(answer6);

        question1.setAnswers(answerCollection);
        question2.setAnswers(answerCollection);
        question3.setAnswers(answerCollection);
        question4.setAnswers(answerCollection);
        question5.setAnswers(answerCollection);
        question6.setAnswers(answerCollection);
        question7.setAnswers(answerCollection);

        List<Question> questions = questionCollection.stream()
                .filter(question -> question.getId() == 1L)
                .collect(Collectors.toList());

        List<Answer> answers = question1.getAnswers().stream()
                .filter(answer -> answer.getQuestionId() == question2.getId())
                .collect(Collectors.toList());


        System.out.println(questions);
        System.out.println(answers);

    }
}