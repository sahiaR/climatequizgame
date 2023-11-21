package com.unfpa.climatequizgame.service;

import com.unfpa.climatequizgame.model.User;
import com.unfpa.climatequizgame.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user) {
        String firstNameUpper = (user.getLoginName()).toUpperCase();
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public List<User> getUserInBase() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserByLoginName(String admin) {
        return userRepository.findByLoginName(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        return userRepository.findByLoginName(loginName).orElseThrow(
                ()-> new UsernameNotFoundException(
                        String.format("USER_NOT_FOUND", loginName)
                ));
    }
}
