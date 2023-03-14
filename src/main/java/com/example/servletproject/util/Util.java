package com.example.servletproject.util;

import com.example.servletproject.Runner;
import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public Long currentQuestionId = 1L;
    public Long nextQuestionId = 0L;
    public Long chosenAnswerId = 0L;

    public void printQuestionAndAnswer(Collection<Question> questions, Collection<Answer> answers) {

        if (nextQuestionId == 0L) {
            String currentQuestionText = questions.stream()
                    .filter(question -> question.getId() == currentQuestionId)
                    .map(question -> question.getText())
                    .collect(Collectors.toList()).toString();

            List<String> answerList = answers.stream().filter(answer -> answer.getQuestionId() == currentQuestionId)
                    .map(answer -> answer.getText())
                    .collect(Collectors.toList());

            List<Long> answersId = answers.stream().filter(answer -> answer.getQuestionId() == currentQuestionId)
                    .map(answer -> answer.getId())
                    .collect(Collectors.toList());

            System.out.println("Question is : " + currentQuestionText);
            System.out.println("Answers are : " + answerList);
            System.out.println("AnswerID is : " + answersId);

        } else {
            String currentQuestionText = questions.stream()
                    .filter(question -> question.getId() == nextQuestionId)
                    .map(question -> question.getText())
                    .collect(Collectors.toList()).toString();

            List<String> answerList = answers.stream().filter(answer -> answer.getQuestionId() == nextQuestionId)
                    .map(answer -> answer.getText())
                    .collect(Collectors.toList());

            List<Long> answersId = answers.stream().filter(answer -> answer.getQuestionId() == nextQuestionId)
                    .map(answer -> answer.getId())
                    .collect(Collectors.toList());

            System.out.println("Question is : " + currentQuestionText);
            System.out.println("Answers are : " + answerList);
            System.out.println("AnswerID is : " + answersId);
        }


    }

    public Question getQuestion(Collection<Question> questions) {
        if (nextQuestionId == 0L) {
            questions.stream()
                    .filter(question -> question.getId() == currentQuestionId);

        }
        return new Question();
    }

    public String finQuestionText(Collection<Question> questions, Collection<Answer> answers) {

        if (nextQuestionId == 0L) {
            String currentQuestionText = questions.stream()
                    .filter(question -> question.getId() == currentQuestionId)
                    .map(question -> question.getText())
                    .collect(Collectors.toList()).toString();


            List<String> answerList = answers.stream().filter(answer -> answer.getQuestionId() == currentQuestionId)
                    .map(answer -> answer.getText())
                    .collect(Collectors.toList());

            List<Long> answersId = answers.stream().filter(answer -> answer.getQuestionId() == currentQuestionId)
                    .map(answer -> answer.getId())
                    .collect(Collectors.toList());

            return currentQuestionText;

        } else {
            String currentQuestionText = questions.stream()
                    .filter(question -> question.getId() == nextQuestionId)
                    .map(question -> question.getText())
                    .collect(Collectors.toList()).toString();

            List<String> answerList = answers.stream().filter(answer -> answer.getQuestionId() == nextQuestionId)
                    .map(answer -> answer.getText())
                    .collect(Collectors.toList());

            List<Long> answersId = answers.stream().filter(answer -> answer.getQuestionId() == nextQuestionId)
                    .map(answer -> answer.getId())
                    .collect(Collectors.toList());

            return currentQuestionText;
        }
    }

    public List<String> getAnswersByQuestionId(Collection<Answer> answers, String questionId) {

        List<String> answerList = answers.stream().filter(answer -> answer.getQuestionId() == currentQuestionId)
                .map(answer -> answer.getText())
                .collect(Collectors.toList());
        return answerList;
    }


    public Long userChoice(Collection<Answer> answers) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String choice = reader.readLine();

        Long userChoice = Long.valueOf(choice);

        String answerReply = answers.stream()
                .filter(answer -> answer.getId() == userChoice)
                .map(answer -> answer.getId())
                .collect(Collectors.toList())
                .toString();

        String test = answerReply.replaceAll("[\\[\\](){}]", "");
        Long answerId = Long.parseLong(test);

        chosenAnswerId = answerId;
        System.out.println("Chosen Answer : " + chosenAnswerId);

        return answerId;
    }

    public Long userJSPChoice(Collection<Answer> answers, String choice) throws IOException {

        Long userChoice = Long.valueOf(choice);

        String answerReply = answers.stream()
                .filter(answer -> answer.getId() == userChoice)
                .map(answer -> answer.getId())
                .collect(Collectors.toList()).toString();

        String test = answerReply.replaceAll("[\\[\\](){}]", "");
        Long answerId = Long.parseLong(test);

        chosenAnswerId = answerId;
        System.out.println("Chosen Answer : " + chosenAnswerId);

        return answerId;
    }

    public Long findNextQuestionByAnswerId(String userAnswer, Collection<Answer> answers) {

        Long answerId = Long.valueOf(userAnswer);
        String findNextQuestionId = answers.stream()
                .filter(answer -> answer.getId() == answerId)
                .map(answer -> answer.getNextQuestionId())
                .collect(Collectors.toList()).toString();

        String test = findNextQuestionId.replaceAll("[\\[\\](){}]", "");
        Long questionId = Long.parseLong(test);

        nextQuestionId = questionId;
        return questionId;
    }
}
