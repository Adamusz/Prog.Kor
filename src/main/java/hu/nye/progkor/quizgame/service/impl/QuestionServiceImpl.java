package hu.nye.progkor.quizgame.service.impl;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.repository.QuestionRepository;
import hu.nye.progkor.quizgame.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final QuestionRepository questionRepository;

  @Override
  public List<Question> getAllQuestion() {
    return questionRepository.findAll();
  }

  @Override
  public Optional<Question> getQuestion(Long id) {
    return questionRepository.findById(id);
  }

  @Override
  public Question createQuestion(Question question) {
    return questionRepository.save(question);
  }

  @Override
  public Question updateQuestion(Long id, Question question) {
    final Question oldQuestion = questionRepository.findById(id).get();
    oldQuestion.setQuestionName(question.getQuestionName());
    oldQuestion.setAnswer(question.getAnswer());
    return questionRepository.save(oldQuestion);
  }

  @Override
  public void deleteQuestion(Long id) {
    questionRepository.delete(questionRepository.getById(id));
  }

}
