package com.buddygoals.buddygoals_backend.repositories;

import com.buddygoals.buddygoals_backend.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal,Long> {
}
