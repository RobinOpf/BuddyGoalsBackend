package com.buddygoals.buddygoals_backend.controllers;

import com.buddygoals.buddygoals_backend.model.Goal;
import com.buddygoals.buddygoals_backend.services.GoalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalService.createGoal(goal);
    }

    @GetMapping("/{id}")
    public Goal getGoalById(@PathVariable Long id) {
        return goalService.getGoalById(id);
    }

    @PutMapping("/{id}")
    public Goal updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        return goalService.updateGoal(id, goal);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id) {
        goalService.deleteGoal(id);
    }
}