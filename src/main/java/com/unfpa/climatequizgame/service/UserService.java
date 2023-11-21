package com.unfpa.climatequizgame.service;

import com.unfpa.climatequizgame.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;


public interface UserService {

    void saveUser(User user);

    List<User> getUserInBase();

    Optional<User> getUserByLoginName(String admin);

}
