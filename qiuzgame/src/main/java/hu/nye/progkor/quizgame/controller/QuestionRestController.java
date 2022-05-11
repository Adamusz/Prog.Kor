package hu.nye.progkor.quizgame.controller;

import java.util.List;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionRestController {

    private final QuestionService questionService;

    @GetMapping
    public List<Question> getQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable("id") final Long id) {
        return questionService.getQuestion(id);
    }

    @PostMapping
    public Question createQuestion(@RequestBody final Question question) {
        return questionService.createQuestion(question);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(final @PathVariable Long id, final @RequestBody Question updatedQuestion) {
        return questionService.updateQuestion(id,updatedQuestion);
    }

    //@DeleteMapping("/{id}")
    //TODO

}
