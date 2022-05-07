package hu.nye.progkor.quizgame.service.impl;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.repository.QuestionRepository;
import hu.nye.progkor.quizgame.repository.UserRepository;
import hu.nye.progkor.quizgame.service.QuizGameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuizGameServiceImpl implements QuizGameService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.getById(id);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

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
