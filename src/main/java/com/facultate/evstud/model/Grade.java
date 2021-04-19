package com.facultate.evstud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "Grade")
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_id")
    private Long id;

    @Column(name = "grade_value")
    private int value;

    @OneToMany(
            mappedBy = "grade",
            cascade = CascadeType.PERSIST,
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    private List<GradeSheet> gradeSheets;
}
