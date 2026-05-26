package com.buddygoals.buddygoals_backend.services;

import com.buddygoals.buddygoals_backend.model.Goal;
import com.buddygoals.buddygoals_backend.repositories.GoalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public Goal getGoalById(Long goalId) {
        return goalRepository.findById(goalId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Goal not found with id: " + goalId
                ));
    }

    public Goal updateGoal(Long goalId, Goal updatedGoal) {
        Goal existingGoal = getGoalById(goalId);

        existingGoal.setDueDate(updatedGoal.getDueDate());
        existingGoal.setEndgoalDescription(updatedGoal.getEndgoalDescription());
        existingGoal.setAnimalType(updatedGoal.getAnimalType());
        existingGoal.setFeedingCondition(updatedGoal.getFeedingCondition());
        existingGoal.setFeedingFrequency(updatedGoal.getFeedingFrequency());
        existingGoal.setErrorsLeft(updatedGoal.getErrorsLeft());
        existingGoal.setPlayer(updatedGoal.getPlayer());

        return goalRepository.save(existingGoal);
    }

    public void deleteGoal(Long goalId) {
        Goal existingGoal = getGoalById(goalId);
        goalRepository.delete(existingGoal);
    }
}