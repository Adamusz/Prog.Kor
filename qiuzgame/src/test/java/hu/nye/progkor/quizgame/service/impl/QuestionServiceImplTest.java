package hu.nye.progkor.quizgame.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.repository.QuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Békési Ádám
 * @date 2022-05-12
 **/
@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

  private static final Long QUESTION_ID = 15L;
  private static final Question QUESTION = new Question(QUESTION_ID, "Kérdés", "Válasz");
  private static final List<Question> QUESTIONS = Arrays.asList(QUESTION, QUESTION);
  private static final Question UNSAVED_QUESTION = new Question(null, "Kérdés", "Válasz");
  @Mock
  private QuestionRepository questionRepository;

  private QuestionServiceImpl underTest;

  @BeforeEach
  public void setUp() {
    underTest = new QuestionServiceImpl(questionRepository);
  }

  @Test
  void getAllQuestion() {
    given(questionRepository.findAll()).willReturn(QUESTIONS);

    List<Question> actual = underTest.getAllQuestion();

    assertEquals(QUESTIONS, actual);
  }

  @Test
  void getQuestion() {
    given(questionRepository.findById(QUESTION_ID)).willReturn(Optional.of(QUESTION));

    Optional<Question> actual = underTest.getQuestion(QUESTION_ID);

    assertEquals(Optional.of(QUESTION), actual);
  }

  @Test
  void createQuestion() {
    given(questionRepository.save(UNSAVED_QUESTION)).willReturn(QUESTION);

    Question actual = underTest.createQuestion(UNSAVED_QUESTION);

    assertEquals(QUESTION, actual);
  }

  @Test
  void updateQuestion() {
    final Question newQuestion = new Question(QUESTION_ID, "Uj", "Valasz");
    given(questionRepository.findById(QUESTION_ID)).willReturn(Optional.of(newQuestion));
    given(questionRepository.save(QUESTION)).willReturn(QUESTION);

    Question actual = underTest.updateQuestion(QUESTION_ID, QUESTION);

    verify(questionRepository).save(QUESTION);
    assertEquals(newQuestion, QUESTION);
  }

  @Test
  void deleteQuestion() {
    underTest.deleteQuestion(QUESTION_ID);
    verify(questionRepository).delete(questionRepository.getById(QUESTION_ID));
  }
}