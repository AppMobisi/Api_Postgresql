package com.mobisi.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Estabelicimento")
@Entity
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cNome")
    private String name;

    @Column(name = "nNota")
    private double score;

    @Column(name = "cCep")
    private int cep;

    @Column(name = "cRua")
    private String neighborhood;

    @Column(name = "cCidade")
    private String city;

    @Column(name = "cEstado")
    private String state;

    @Column(name = "cPais")
    private String country;
}
