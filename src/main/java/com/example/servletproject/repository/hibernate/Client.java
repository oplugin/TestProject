package com.example.servletproject.repository.hibernate;

import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Client {

    public static void main(String[] args) {
        SessionCreator sessionCreator = new SessionCreator();

        Question question = Question.builder()
                .text("Ты потерял память. Принять вызов НЛО?")
                .gameState(GameState.PLAY)
                .build();

        Session session = sessionCreator.getSession();

        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                session.persist(question);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
        }
        System.out.println(question.getId());
    }
}
