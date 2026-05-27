package com.buddygoals.buddygoals_backend.services;

import com.buddygoals.buddygoals_backend.model.Goal;
import com.buddygoals.buddygoals_backend.model.Player;
import com.buddygoals.buddygoals_backend.model.SchoolClass;
import com.buddygoals.buddygoals_backend.repositories.PlayerRepository;
import com.buddygoals.buddygoals_backend.repositories.SchoolClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final SchoolClassRepository schoolClassRepository;

    public PlayerService(PlayerRepository playerRepository,
                         SchoolClassRepository schoolClassRepository) {
        this.playerRepository = playerRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    //Post
    public Player createPlayer(Player player) {
        if (player.getSchoolClass() != null && player.getSchoolClass().getId() != null) {
            SchoolClass schoolClass = schoolClassRepository.findById(player.getSchoolClass().getId())
                    .orElseThrow(() -> new RuntimeException("SchoolClass not found"));
            player.setSchoolClass(schoolClass);
        }

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
        if (updatedPlayer.getSchoolClass() != null && updatedPlayer.getSchoolClass().getId() != null) {
            SchoolClass schoolClass = schoolClassRepository.findById(updatedPlayer.getSchoolClass().getId())
                    .orElseThrow(() -> new RuntimeException("SchoolClass not found"));
            existing.setSchoolClass(schoolClass);
        }

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
