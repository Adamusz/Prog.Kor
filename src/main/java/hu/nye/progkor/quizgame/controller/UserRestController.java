package hu.nye.progkor.quizgame.controller;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Békési Ádám
 * @date 2022-05-11
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

  private final UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.getAllUser();
  }

  @GetMapping("/{id}")
  Optional<User> getUserById(@PathVariable(name = "id") final Long id) {
    return userService.getUser(id);
  }

  @PostMapping
  User createUser(@RequestBody final User user) {
    return userService.createUser(user);
  }

  @PutMapping("/{id}")
  User updateUser(@PathVariable(name = "id") final Long id, User user) {
    return userService.updateUser(id, user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(final @PathVariable(name = "id") Long id) {
    userService.deleteUser(id);
  }
}
