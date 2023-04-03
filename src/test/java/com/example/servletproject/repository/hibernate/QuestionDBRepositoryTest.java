package com.example.servletproject.repository.hibernate;

import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionDBRepositoryTest {

    private QuestionDBRepository questionDBRepository;

    @BeforeEach
    void setup() {
        questionDBRepository = new QuestionDBRepository(new SessionCreator());
    }

    @Test
    void get() {
        Question question = questionDBRepository.get(1L);
        assertEquals("Ты потерял память. Принять вызов НЛО?", question.getText());
    }

    @Test
    void create() {

        Question question = Question.builder()
                .text("Ты потерял память. Принять вызов НЛО?")
                .gameState(GameState.PLAY)
                .build();
        questionDBRepository.create(question);
        assertTrue(question.getId() > 0);
    }
}
