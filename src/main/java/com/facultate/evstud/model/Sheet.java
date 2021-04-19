package com.facultate.evstud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "Sheet")
@Table(name = "sheet")
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sheet_id")
    private Long id;

    @Column(name = "")
    private int forYearOfStudy;

    @OneToMany(
            mappedBy = "sheet",
            cascade = CascadeType.PERSIST,
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    private List<GradeSheet> gradeSheets;

    @OneToOne(
            mappedBy = "sheet",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private ResolvedSheet resolvedSheet;
}
