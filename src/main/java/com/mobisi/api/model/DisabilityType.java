package com.mobisi.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tp_deficiencia")
public class DisabilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iid")
    private Long id;

    @Column(name = "cnome")
    private String nome;

}
