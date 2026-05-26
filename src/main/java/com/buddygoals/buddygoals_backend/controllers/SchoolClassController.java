package com.buddygoals.buddygoals_backend.controllers;

import com.buddygoals.buddygoals_backend.model.Player;
import com.buddygoals.buddygoals_backend.model.SchoolClass;
import com.buddygoals.buddygoals_backend.services.SchoolClassService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schoolClass")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping
    public SchoolClass createSchoolClass(@RequestBody SchoolClass schoolClass) {
        return schoolClassService.createSchoolClass(schoolClass);
    }

    @GetMapping("/{id}")
    public SchoolClass getSchoolClassById(@PathVariable Long id) {
        return schoolClassService.getSchoolClassById(id);
    }

    @PutMapping("/{id}")
    public SchoolClass updateSchoolClass(@PathVariable Long id,
                                         @RequestBody SchoolClass schoolClass) {
        return schoolClassService.updateSchoolClass(id, schoolClass);
    }

    @DeleteMapping("/{id}")
    public void deleteSchoolClass(@PathVariable Long id) {
        schoolClassService.deleteSchoolClass(id);
    }

    @GetMapping("/{id}/players")
    public List<Player> getPlayersBySchoolClass(@PathVariable Long id) {
        return schoolClassService.getPlayersBySchoolClass(id);
    }
}