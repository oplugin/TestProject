package com.example.servletproject.repository.hibernate;

import com.example.servletproject.entity.Question;
import com.example.servletproject.exception.AppException;
import com.example.servletproject.repository.Repository;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.stream.Stream;


@RequiredArgsConstructor
public class QuestionDBRepository implements Repository<Question> {

    private final SessionCreator sessionCreator;

    @Override
    public Collection<Question> getAll() {
        return null;
    }

    @Override
    public Stream<Question> find(Question pattern) {
        return null;
    }

    @Override
    public Question get(long id) {

        Session session = sessionCreator.getSession();
        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                Question question = session.get(Question.class, id);
                tx.commit();
                return question;
            } catch (Exception e) {
                tx.rollback();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void create(Question question) {

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

    }

    @Override
    public void update(Question question) {

        Session session = sessionCreator.getSession();
        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                session.merge(question);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
        }
    }

    @Override
    public void delete(Question question) {
        Session session = sessionCreator.getSession();
        try (session) {
            Transaction tx = session.beginTransaction();
            try {
                session.remove(question);
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
        }
    }
}
