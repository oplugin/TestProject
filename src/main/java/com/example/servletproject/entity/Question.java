package com.example.servletproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
;import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@ToString
@Table(name = "question")
public class Question implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Enumerated(EnumType.STRING)
    @Transient
    private GameState gameState;
    @JsonIgnore
    @Transient
    private final Collection<Answer> answers = new ArrayList<>();

}
