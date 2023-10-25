package com.mobisi.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iid")
    private Long id;

    @Column(name = "cnome")
    private String name;

    @Column(name = "ccpf")
    private String cpf;

    @Column(name = "cemail")
    private String email;

    @Column(name = "csenha")
    private String password;

    @Column(name = "ctelefone")
    private String phone;

    @Column(name = "iidade")
    private int age;

    @Column(name = "icep")
    private int cep;

    @Column(name = "ccidade")
    private String city;

    @Column(name = "cbairro")
    private String neighborhood;

    @Column(name = "cestado")
    private String state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "itipodeficienciaid")
    private DisabilityType disabilityType;

    @Column(name = "bativo")
    private boolean status;
}