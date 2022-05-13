package hu.nye.progkor.quizgame.repository;

import hu.nye.progkor.quizgame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}
