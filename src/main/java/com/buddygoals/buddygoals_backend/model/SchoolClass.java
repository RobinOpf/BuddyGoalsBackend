package com.buddygoals.buddygoals_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teacherName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String classDescription;

    @OneToMany(mappedBy = "schoolClass")
    @JsonIgnore
    private List<Player> players = new ArrayList<>();
}
