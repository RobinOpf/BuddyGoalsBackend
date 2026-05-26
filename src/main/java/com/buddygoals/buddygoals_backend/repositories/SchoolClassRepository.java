package com.buddygoals.buddygoals_backend.repositories;

import com.buddygoals.buddygoals_backend.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
}
