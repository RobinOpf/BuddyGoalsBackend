package com.buddygoals.buddygoals_backend.repositories;

import com.buddygoals.buddygoals_backend.model.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolClassRepository extends JpaRepository<SchoolClass, Long> {
    Optional<SchoolClass> findByTeacherName(String teacherName);
}
