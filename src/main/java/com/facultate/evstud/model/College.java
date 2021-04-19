package com.facultate.evstud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "College")
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "college_id")
    private Long id;

    @Column(name = "college_name", unique = true)
    private String name;

    @Column(name = "number_of_students", unique = false)
    private int numberOfStudents;

    @OneToMany(
            mappedBy = "college",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Teacher> teachers;

    @OneToMany(
            mappedBy = "college",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Student> students;
}
