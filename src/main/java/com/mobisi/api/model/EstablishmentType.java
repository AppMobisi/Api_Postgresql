package com.mobisi.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "")
public class EstablishmentType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iid")
    private Long id;

    @Column(name = "cnome")
    private String nome;
}
