package com.buddygoals.buddygoals_backend.services;

import com.buddygoals.buddygoals_backend.model.Goal;
import com.buddygoals.buddygoals_backend.model.Player;
import com.buddygoals.buddygoals_backend.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    //Constructor
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //Post
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    //Get by ID
    public Player getPlayer(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() ->
                        new RuntimeException("Player not found with id: " + playerId));
    }

    //Update
    public Player updatePlayer(Long playerId, Player updatedPlayer) {
        Player existing = getPlayer(playerId);

        existing.setUsername(updatedPlayer.getUsername());
        existing.setPassword(updatedPlayer.getPassword());
        existing.setSchoolClass(updatedPlayer.getSchoolClass());

        return playerRepository.save(existing);
    }

    //Delete
    public void deletePlayer(Long playerId) {
        Player existing = getPlayer(playerId);
        playerRepository.delete(existing);
    }

    public List<Goal> getGoalsByPlayerId(Long playerId) {
        Player player = getPlayer(playerId);
        return player.getGoals();
    }
}
