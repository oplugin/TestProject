package com.example.servletproject.config;

import com.example.servletproject.entity.Answer;
import com.example.servletproject.entity.GameState;
import com.example.servletproject.entity.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


public final class Config {
    private String JSON_QUESTIONS = "QuestText/questions.json";
    private String JSON_ANSWERS = "answers.json";
    JSONParser parser = new JSONParser();

    Question question = new Question();
    Collection<Question> questionCollection = new ArrayList<>();
    Collection<Answer> answerCollection = new ArrayList<>();

    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream("QuestText/questions.json");


    public Collection<Question> jsonQuestionArrayParser(String path) throws IOException {

/**
 *
 *        FileInputStream fis = new FileInputStream(file);
 *        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
 *        BufferedReader reader = new BufferedReader(isr)
 *
 *
 *        FileReader reader = new FileReader(path)
 *
 */


        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(isr)) {

            JSONArray jsonArray = (JSONArray) parser.parse(reader);

            for (Object object : jsonArray) {
                JSONObject jsonQuestion = (JSONObject) object;

                Question question = new Question();

                Long id = (Long) jsonQuestion.get("id");
                question.setId(id);

                String text = (String) jsonQuestion.get("text");
                question.setText(text);

                String gameState = (String) jsonQuestion.get("gameState");
                question.setGameState(GameState.valueOf(gameState));

                questionCollection.add(question);
            }

            return questionCollection;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return null;
    }


//    public Collection<Question> jsonAnswerArrayParser() {
//
//        JSONParser parser = new JSONParser();
//
//        try {
//            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(JSON_ANSWERS));
//
//            for (Object object : jsonArray) {
//                JSONObject jsonQuestion = (JSONObject) object;
//
//                Question question = new Question();
//
//                Long id = (Long) jsonQuestion.get("id");
//                question.setId(id);
//
//                String text = (String) jsonQuestion.get("text");
//                question.setText(text);
//
//                String gameState = (String) jsonQuestion.get("gameState");
//                question.setGameState(GameState.valueOf(gameState));
//
//                questionCollection.add(question);
//            }
//
//            return questionCollection;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//
//    }

//    public void initQuestData() {
//        Config.getData(JSON_QUESTIONS, Question.class);
//    }
//
//    public static <T> List<Question> getData (String fileName, Class<T> type ) {
//        ObjectMapper mapper = new JsonMapper();
//        File file = getFile(fileName);
//        try {
//            JavaType javaType = mapper.getTypeFactory()
//                    .constructParametricType(List.class, type);
//            return mapper.readValue(file, javaType);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static File getFile(String fileName) {
//        URL resource = Config.class.getClassLoader().getResource(fileName);
//        if (resource == null) {
//            throw new IllegalArgumentException("file not found!");
//        }
//        return new File(resource.getFile());
//    }
}
