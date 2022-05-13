package hu.nye.progkor.quizgame.service.impl;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.repository.UserRepository;
import hu.nye.progkor.quizgame.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Békési Ádám
 * @date 2022-05-11
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  @Override
  public Optional<User> getUser(Long id) {
    return userRepository.findById(id);
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public User updateUser(Long id, User user) {
    final User oldUser = userRepository.findById(id).get();
    oldUser.setUserName(user.getUserName());
    oldUser.setEmail(user.getEmail());
    oldUser.setPassword(user.getPassword());
    oldUser.setScore(user.getScore());
    return userRepository.save(oldUser);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.delete(userRepository.getById(id));
  }
}
