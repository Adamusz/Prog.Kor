package hu.nye.progkor.quizgame.service;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.User;

/**
 * @author Békési Ádám
 * @date 2022-05-11
 **/
public interface UserService {

  List<User> getAllUser();

  Optional<User> getUser(Long id);

  User createUser(User user);

  User updateUser(Long id, User user);

  void deleteUser(Long id);
}
