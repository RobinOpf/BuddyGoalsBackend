package com.buddygoals.buddygoals_backend.services;

import com.buddygoals.buddygoals_backend.model.Goal;
import com.buddygoals.buddygoals_backend.model.Player;
import com.buddygoals.buddygoals_backend.repositories.GoalRepository;
import com.buddygoals.buddygoals_backend.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final PlayerRepository playerRepository;

    public GoalService(GoalRepository goalRepository,
                       PlayerRepository playerRepository) {
        this.goalRepository = goalRepository;
        this.playerRepository = playerRepository;
    }

    public Goal createGoal(Goal goal) {
        if (goal.getPlayer() != null && goal.getPlayer().getId() != 0) {
            Player player = playerRepository.findById(goal.getPlayer().getId())
                    .orElseThrow(() -> new RuntimeException("Player not found"));
            goal.setPlayer(player);
        }

        return goalRepository.save(goal);
    }

    public Goal getGoalById(Long goalId) {
        return goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal not found with id: " + goalId));
    }

    public Goal updateGoal(Long goalId, Goal updatedGoal) {
        Goal existingGoal = getGoalById(goalId);

        existingGoal.setDueDate(updatedGoal.getDueDate());
        existingGoal.setEndgoalDescription(updatedGoal.getEndgoalDescription());
        existingGoal.setAnimalType(updatedGoal.getAnimalType());
        existingGoal.setFeedingCondition(updatedGoal.getFeedingCondition());
        existingGoal.setFeedingFrequencyValue(updatedGoal.getFeedingFrequencyValue());
        existingGoal.setFeedingFrequencyUnit(updatedGoal.getFeedingFrequencyUnit());
        existingGoal.setLastFedAt(updatedGoal.getLastFedAt());
        existingGoal.setErrorsLeft(updatedGoal.getErrorsLeft());

        if (updatedGoal.getPlayer() != null && updatedGoal.getPlayer().getId() != 0) {
            Player player = playerRepository.findById(updatedGoal.getPlayer().getId())
                    .orElseThrow(() -> new RuntimeException("Player not found"));
            existingGoal.setPlayer(player);
        }

        return goalRepository.save(existingGoal);
    }

    public void deleteGoal(Long goalId) {
        Goal existingGoal = getGoalById(goalId);
        goalRepository.delete(existingGoal);
    }
}