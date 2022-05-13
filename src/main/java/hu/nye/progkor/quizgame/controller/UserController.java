package hu.nye.progkor.quizgame.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import hu.nye.progkor.quizgame.model.User;
import hu.nye.progkor.quizgame.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

  @Autowired
  private final UserRepository userRepository;

  @GetMapping(path = "/registration.html")
  public String showRegistrationForm(Model model) {
    model.addAttribute("user", new User());
    return "registration";
  }

  @PostMapping(path = "/registration", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String registrationForm(User user) {
    userRepository.save(user);
    return "login";
  }

  @GetMapping(path = "/login.html")
  public String showLoginForm(Model model) {
    model.addAttribute("user", new User());
    return "login";
  }

  @PostMapping(path = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String loginForm(User user, HttpServletRequest request, HttpSession session) {
    session.invalidate();
    User user1 = userRepository.findByEmail(user.getEmail());
    if (user1.getPassword().equals(user.getPassword())) {
      HttpSession newSession = request.getSession();
      return "home";
    } else {
      return "login";
    }
  }
}
