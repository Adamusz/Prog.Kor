package hu.nye.progkor.quizgame.controller;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.service.QuizGameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/quizgame")
public class QuizGameRestController {

    private final QuizGameService quizGameService;

    @GetMapping("/{id}")
    Question getQuestion(@PathVariable("id") final Long id){
        return quizGameService.getQuestion(id);
    }

    @PostMapping
    Question createQuestion(@RequestBody final Question question){
        return quizGameService.createQuestion(question);
    }

    /*@GetMapping("{/id}")
    User getUser(@PathVariable("id") final Long id){
        return quizGameService.getUser(id);
    }

    @PostMapping
    User createUser(@RequestBody final User user){
        return quizGameService.createUser(user);
    }*/

    @PutMapping("/{id}")
    User updateUser(@PathVariable final Long id,@RequestBody final User updatedUser){
        return quizGameService.updateUser(id, updatedUser);
    }

}
