package com.example.servletproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
;import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Question implements AbstractEntity {

    private Long id;

    private String text;

    private GameState gameState;
    @JsonIgnore
    private final Collection<Answer> answers = new ArrayList<>();

}
