package hu.nye.progkor.quizgame.service;

import java.util.List;

import hu.nye.progkor.quizgame.model.Question;

public interface QuestionService {

    List<Question> getAllQuestion();

    Question getQuestion(Long id);

    Question createQuestion(Question question);

    Question updateQuestion(Long id, Question updatedQuestion);
}
