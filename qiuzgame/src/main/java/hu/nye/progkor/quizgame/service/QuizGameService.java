package hu.nye.progkor.quizgame.service;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.model.User;

public interface QuizGameService {

    Question getQuestion(Long id);

    Question createQuestion(Question question);

    User getUser(Long id);

    User createUser(User user);

    User updateUser(Long id, User updatedUser);
}
