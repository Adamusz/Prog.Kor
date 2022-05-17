package hu.nye.progkor.quizgame.controller;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.repository.QuestionRepository;
import hu.nye.progkor.quizgame.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {

  @Autowired
  private QuestionRepository questionRepository;

  @GetMapping(path = "/home.html")
  public String showHome() {
    return "home";
  }

  @GetMapping(path = "/game.html")
  public String showGame() {
    return "game";
  }

  @GetMapping(path = "/newquestion.html")
  public String showNewQuestion(Model model) {
    model.addAttribute("question", new Question());
    return "newquestion";
  }

  @PostMapping(path = "/newquestion", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String newQuestionForm(Question question) {
    questionRepository.save(question);
    return "home";
  }

}
