package com.example.servletproject.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game implements AbstractEntity {

    private Long id;
    private Long currentQuestionId;
    private GameState gameState;

}
