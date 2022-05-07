package hu.nye.progkor.quizgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    @GetMapping(path = "/home.html")
    public String showHome() {
        return "home";
    }

    @GetMapping(path = "/game.html")
    public String showGame(){
        return "game";
    }
}
