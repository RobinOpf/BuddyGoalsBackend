package com.buddygoals.buddygoals_backend.model;

import com.buddygoals.buddygoals_backend.enums.FeedingFrequencyUnit;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private String feedingCondition;

    private int feedingFrequencyValue;

    @Enumerated(EnumType.STRING)
    private FeedingFrequencyUnit feedingFrequencyUnit;

    private LocalDateTime lastFedAt;

    private int errorsLeft;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
}