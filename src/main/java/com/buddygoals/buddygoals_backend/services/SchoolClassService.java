package com.buddygoals.buddygoals_backend.services;

import com.buddygoals.buddygoals_backend.model.Player;
import com.buddygoals.buddygoals_backend.model.SchoolClass;
import com.buddygoals.buddygoals_backend.repositories.PlayerRepository;
import com.buddygoals.buddygoals_backend.repositories.SchoolClassRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final PlayerRepository playerRepository;

    public SchoolClassService(SchoolClassRepository schoolClassRepository,
                              PlayerRepository playerRepository) {
        this.schoolClassRepository = schoolClassRepository;
        this.playerRepository = playerRepository;
    }

    public SchoolClass createSchoolClass(SchoolClass schoolClass) {
        return schoolClassRepository.save(schoolClass);
    }

    public SchoolClass getSchoolClassById(Long id) {
        return schoolClassRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "SchoolClass not found with id: " + id
                ));
    }

    public SchoolClass updateSchoolClass(Long id, SchoolClass updatedSchoolClass) {
        SchoolClass existing = getSchoolClassById(id);

        existing.setTeacherName(updatedSchoolClass.getTeacherName());
        existing.setPassword(updatedSchoolClass.getPassword());
        existing.setClassDescription(updatedSchoolClass.getClassDescription());

        return schoolClassRepository.save(existing);
    }

    public void deleteSchoolClass(Long id) {
        SchoolClass existing = getSchoolClassById(id);
        schoolClassRepository.delete(existing);
    }

    public List<Player> getPlayersBySchoolClass(Long id) {
        getSchoolClassById(id); // checks class exists
        return playerRepository.findBySchoolClassId(id);
    }
}