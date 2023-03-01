package com.example.servletproject.entity;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer implements AbstractEntity {
    private Long id;
    private String text;
    private Long questionId;
    private Long nextQuestionId;
}
