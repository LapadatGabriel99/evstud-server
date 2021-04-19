package com.facultate.evstud.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ResolvedSheet")
@Table(name = "Resolved_Sheet")
public class ResolvedSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resolved_sheet_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sheet_id", nullable = false)
    private Sheet sheet;
}
