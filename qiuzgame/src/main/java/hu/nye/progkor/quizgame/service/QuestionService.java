package hu.nye.progkor.quizgame.service;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.Question;

public interface QuestionService {

  List<Question> getAllQuestion();

  Optional<Question> getQuestion(Long id);

  Question createQuestion(Question question);

  Question updateQuestion(Long id, Question question);

  void deleteQuestion(Long id);

}
