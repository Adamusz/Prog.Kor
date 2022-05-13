package hu.nye.progkor.quizgame.controller;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionRestController {

  private final QuestionService questionService;

  @GetMapping
  public List<Question> getQuestions() {
    return questionService.getAllQuestion();
  }

  @GetMapping("/{id}")
  public Optional<Question> getQuestionById(@PathVariable(name = "id") final Long id) {
    return questionService.getQuestion(id);
  }

  @PostMapping
  public Question createQuestion(@RequestBody final Question question) {
    return questionService.createQuestion(question);
  }

  @PutMapping("/{id}")
  public Question updateQuestion(final @PathVariable(name = "id") Long id,
                                 @RequestBody final Question question) {
    return questionService.updateQuestion(id, question);
  }

  @DeleteMapping("/{id}")
  public void deleteQuestion(final @PathVariable(name = "id") Long id) {
    questionService.deleteQuestion(id);
  }

}
