package com.unfpa.climatequizgame.repository;

import com.unfpa.climatequizgame.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Players, Long> {
}
