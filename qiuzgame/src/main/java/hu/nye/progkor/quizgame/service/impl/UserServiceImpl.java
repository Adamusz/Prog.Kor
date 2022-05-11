package hu.nye.progkor.quizgame.service.impl;

import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.repository.UserRepository;
import hu.nye.progkor.quizgame.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Békési Ádám
 * @date 2022-05-11
 **/
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        updatedUser = userRepository.getById(id);
        return userRepository.save(updatedUser);
    }
}
