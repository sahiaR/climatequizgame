package com.unfpa.climatequizgame.service;

import com.unfpa.climatequizgame.model.Team;
import com.unfpa.climatequizgame.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TeamService {
    private final TeamRepository teamRepository;


    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    public Team saveTeam(Team team){
        return teamRepository.save(team);
    }
    public Team updateTeam(Long id, Team updatedTeam) {
        Optional<Team> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            Team teamToUpdate = existingTeam.get();
            teamToUpdate.setScore(updatedTeam.getScore());
            teamToUpdate.setStatus(updatedTeam.isStatus());
            return teamRepository.save(teamToUpdate);
        } else {
          throw new RuntimeException("the player with id "+ id+ "doesnt exist");
        }

    }

}
