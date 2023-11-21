package com.unfpa.climatequizgame.service;

import com.unfpa.climatequizgame.model.Players;
import com.unfpa.climatequizgame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    private  final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public Players savePlayers(Players players){
        return playerRepository.save(players);
    }
    public Optional<Players> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }
    public Players updatePlayers(long id,Players players){
        Optional<Players> existPLayer = playerRepository.findById(id);
        if (existPLayer.isPresent()){
            Players playersToUpdate = existPLayer.get();
            playersToUpdate.setNom(players.getNom());
            return playerRepository.save(playersToUpdate);
        }else throw new RuntimeException("the player with id "+ id+ "doesnt exist");
    }
}
