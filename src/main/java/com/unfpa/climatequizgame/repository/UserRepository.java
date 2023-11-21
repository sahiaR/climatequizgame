package com.unfpa.climatequizgame.repository;

import com.unfpa.climatequizgame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginName(String loginName);

}
