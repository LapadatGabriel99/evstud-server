package com.facultate.evstud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_name", unique = true)
    private String username;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_email", unique = true)
    private String email;

    @Column(name = "user_firstname", unique = false)
    private String firstname;

    @Column(name = "user_lastname", unique = false)
    private String lastname;

    @Column(name = "user_phone", unique = true)
    private int phone;

    @Column(name = "user_age", unique = false)
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Admin admin;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Student student;

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Teacher teacher;
}
