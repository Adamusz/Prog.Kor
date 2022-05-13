package hu.nye.progkor.quizgame.repository;

import hu.nye.progkor.quizgame.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
