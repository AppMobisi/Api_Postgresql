package com.mobisi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Estabelecimento")
@Entity
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cNome")
    private String name;

    @Column(name = "nNota")
    private double score;

    @Column(name = "cCep")
    private String cep;

    @Column(name = "cRua")
    private String neighborhood;

    @Column(name = "cCidade")
    private String city;

    @Column(name = "cEstado")
    private String state;

    @Column(name = "iTpEstabelecimento")
    private int typeOfEstablishment;

}
