package com.mobisi.api.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "tp_deficiencia")
public class DisabilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iid")
    private Long id;

    @Column(name = "cnome")
    private String nome;

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "DisabilityType{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
