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
@Table(name = "usuarios")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cNome")
    private String name;

    @Column(name = "cEmail")
    private String email;

    @Column(name = "cSenha")
    private String password;

    @Column(name = "cTelefone")
    private String phone;

    @Column(name = "iIdade")
    private int age;

    @Column(name = "cCep")
    private String cep;

    @Column(name = "cCidade")
    private String city;

    @Column(name = "cBairro")
    private String neighborhood;

    @Column(name = "cEstado")
    private String state;

    @Column(name = "cPais")
    private String country;

    @Column(name = "fk_TpDeficiencia_Id")
    private int typeOfDisability;

    @Column(name = "bAtivo")
    private boolean status;
}
