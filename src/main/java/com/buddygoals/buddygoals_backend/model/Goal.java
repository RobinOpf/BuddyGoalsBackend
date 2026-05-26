package com.buddygoals.buddygoals_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long goalId;

    private LocalDate dueDate;
    private String endgoalDescription;
    private int animalType;
    private int feedingCondition;
    private LocalDate feedingFrequency;
    private int errorsLeft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    @JsonIgnore
    private Player player;
}