package com.facultate.evstud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "GradeSheet")
@Table(name = "grade_sheet")
public class GradeSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "grade_sheet_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "grad_id")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "sheet_id")
    private Sheet sheet;
}
