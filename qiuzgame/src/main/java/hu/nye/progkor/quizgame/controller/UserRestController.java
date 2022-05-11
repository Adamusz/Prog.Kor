package hu.nye.progkor.quizgame.controller;

import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Békési Ádám
 * @date 2022-05-11
 **/
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    @GetMapping("{/id}")
    User getUser(@PathVariable("id") final Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    User createUser(@RequestBody final User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    User updateUser(@PathVariable final Long id, @RequestBody final User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
}
