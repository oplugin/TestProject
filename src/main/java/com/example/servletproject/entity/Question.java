package com.example.servletproject.entity;

import lombok.*;
;import java.util.ArrayList;
import java.util.Collection;


public class Question {

    private Long id;
    private String text;
    private Collection<Answer> answers = new ArrayList<>();

    public Question(Long id, String text, GameState gameState) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Collection<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(Collection<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    @Override
    public String toString() {
        return "\nQuestion\n\t{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", answers=" + answers +
                '}';
    }
}
