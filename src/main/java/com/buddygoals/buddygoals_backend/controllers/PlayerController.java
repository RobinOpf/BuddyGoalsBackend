package com.buddygoals.buddygoals_backend.controllers;

import com.buddygoals.buddygoals_backend.model.Goal;
import com.buddygoals.buddygoals_backend.model.Player;
import com.buddygoals.buddygoals_backend.services.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable Long id) {
        return playerService.getPlayer(id);
    }

    @PutMapping("/{id}")
    public Player update(@PathVariable Long id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }

    @GetMapping("/{id}/goals")
    public List<Goal> getGoals(@PathVariable Long id) {
        return playerService.getGoalsByPlayerId(id);
    }
}

