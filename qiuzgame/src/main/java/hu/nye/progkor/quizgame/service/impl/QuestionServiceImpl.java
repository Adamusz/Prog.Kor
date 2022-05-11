package hu.nye.progkor.quizgame.service.impl;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.Question;
import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.repository.QuestionRepository;
import hu.nye.progkor.quizgame.repository.UserRepository;
import hu.nye.progkor.quizgame.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getAllQuestion(){
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.getById(id);
    }

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Long id, Question updatedQuestion) {
        Optional<Question> question = questionRepository.findById(id);
        return null;
    }

}
