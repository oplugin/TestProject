package com.example.servletproject.service;

import com.example.servletproject.entity.Question;
import com.example.servletproject.repository.AnswerRepository;
import com.example.servletproject.repository.QuestionRepository;

import java.util.Collection;

public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuestionService(QuestionRepository questionRepository, AnswerRepository answerRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    public Collection<Question> getQuestionList() {
        Collection<Question> questions = questionRepository.getAll();
        return questions;
    }

//    public static final String QUEST_SYMBOL = ":";
//    public static final String WIN_SYMBOL = "+";
//    public static final String LOST_SYMBOL = "-";
//    public static final String LINK_SYMBOL = "<";
//    public static final String DIGITS = "\\d+";
//
//    private final QuestionRepository questionRepository;
//
//    public Optional<Question> get(long id) {
//        return Optional.of(questionRepository.get(id));
//    }
//
//    public Collection<Question> getAll(){
//        return questionRepository.getAll();
//    }
//
//    @SneakyThrows
//    public Optional<Question> update(Long questionId, String text) {
//        Question question = questionRepository.get(questionId);
//        question.setText(text);
//        questionRepository.update(question);
//        return Optional.of(question);
//    }
//
//    public Map<Long, Question> fillDraftMap(String text) {
//        Map<Long, Question> map = new TreeMap<>();
//        text = "\n" + text;
//        String pattern = "\n(%s)([:<+-])".formatted(DIGITS);
//        String[] parts = text.split(pattern);
//        int index = 1;
//        Matcher labelIterator = Pattern.compile(pattern).matcher(text);
//        Question question = new Question();
//        while (labelIterator.find()) {
//            long key = Long.parseLong(labelIterator.group(1));
//            String type = labelIterator.group(2);
//            String partText = parts[index++].strip();
//            Optional<Question> newQuestion = fillQuestion(question, key, type, partText);
//            if (newQuestion.isPresent()) {
//                question = newQuestion.get();
//                map.put(key, question);
//            }
//        }
//        return map;
//    }
//
//    private Optional<Question> fillQuestion(Question currentQuestion, long key, String type, String partText) {
//        currentQuestion = switch (type) {
//            case QUEST_SYMBOL -> Question.builder().text(partText).gameState(GameState.PLAY).build();
//            case WIN_SYMBOL -> Question.builder().text(partText).gameState(GameState.WIN).build();
//            case LOST_SYMBOL -> Question.builder().text(partText).gameState(GameState.LOST).build();
//            case LINK_SYMBOL -> {
//                Answer build = Answer.builder()
//                        .nextQuestionId(key)
//                        .questionId(0L)
//                        .text(partText)
//                        .build();
//                currentQuestion.getAnswers().add(build);
//                yield null;
//            }
//            default -> throw new AppException("incorrect parsing");
//        };
//        return Optional.ofNullable(currentQuestion);
//    }
}
