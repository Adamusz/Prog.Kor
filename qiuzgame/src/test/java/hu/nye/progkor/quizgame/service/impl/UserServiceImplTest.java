package hu.nye.progkor.quizgame.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


/**
 * @author Békési Ádám
 * @date 2022-05-12
 **/
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  private static final Long USER_ID = 15L;
  private static final String USER_NAME = "Teszt";
  private static final String USER_PASSWORD = "jelszo";
  private static final String USER_EMAIL = "email@email.com";
  private static final int USER_SCORE = 5;
  private static final User USER = new User(USER_ID, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_SCORE);
  private static final List<User> USERS = Arrays.asList(USER, USER);
  private static final User UNSAVED_USER = new User(null, USER_NAME, USER_PASSWORD, USER_EMAIL, USER_SCORE);
  @Mock
  private UserRepository userRepository;

  private UserServiceImpl underTest;

  @BeforeEach
  public void setUp() {
    underTest = new UserServiceImpl(userRepository);
  }

  @Test
  public void getAllUser() {

    given(userRepository.findAll()).willReturn(USERS);

    List<User> actual = underTest.getAllUser();

    assertEquals(USERS, actual);

  }

  @Test
  public void getUser() {
    given(userRepository.findById(USER_ID)).willReturn(Optional.of(USER));

    Optional<User> actual = underTest.getUser(USER_ID);

    assertEquals(Optional.of(USER), actual);
  }

  @Test
  public void createUser() {
    given(userRepository.save(UNSAVED_USER)).willReturn(USER);

    User actual = underTest.createUser(UNSAVED_USER);

    assertEquals(USER, actual);
  }


  @Test
  public void updateUser() {
    final User newUser = new User(USER_ID, "Uj", "ujJelszo", "ujEmail@email.com", 6);
    given(userRepository.findById(USER_ID)).willReturn(Optional.of(newUser));
    given(userRepository.save(USER)).willReturn(USER);

    User actual = underTest.updateUser(USER_ID, USER);

    verify(userRepository).save(USER);
    assertEquals(newUser, USER);
  }

  @Test
  public void deleteUser() {
    underTest.deleteUser(USER_ID);
    verify(userRepository).delete(userRepository.getById(USER_ID));
  }

}