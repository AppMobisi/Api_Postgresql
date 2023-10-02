package com.mobisi.backend.Api.Repositories.DAOs;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.management.ConstructorParameters;

@Getter
@Setter
@ToString
@Table(name = "usuario")
@Entity
public class UserDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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

    public UserDAO(String nome, String email, String password, String telefone, int idade, String cep, String cidade, String bairro, String estado, String pais, int tipoDeficiencia){
        this.name = nome;
        this.email = email;
        this.password = password;
        this.phone = telefone;
        this.age = idade;
        this.cep = cep;
        this.city = cidade;
        this.neighborhood = bairro;
        this.state = estado;
        this.country = pais;
        this.typeOfDisability = tipoDeficiencia;
        this.status = true;
    }

    public UserDAO() {}
}
