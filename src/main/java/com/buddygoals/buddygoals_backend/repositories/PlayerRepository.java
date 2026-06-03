package com.buddygoals.buddygoals_backend.repositories;

import com.buddygoals.buddygoals_backend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findBySchoolClassId(Long schoolClassId);

    Optional<Player> findByUsername(String username);
}