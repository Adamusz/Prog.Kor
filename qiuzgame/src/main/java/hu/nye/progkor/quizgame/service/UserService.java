package hu.nye.progkor.quizgame.service;

import hu.nye.progkor.quizgame.model.User;

/**
 * @author Békési Ádám
 * @date 2022-05-11
 **/
public interface UserService {

    User getUser(Long id);

    User createUser(User user);

    User updateUser(Long id, User updatedUser);
}
