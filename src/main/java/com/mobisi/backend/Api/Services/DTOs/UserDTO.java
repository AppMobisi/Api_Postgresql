package com.mobisi.backend.Api.Services.DTOs;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private long id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private String cep;
    private int typeOfDisability;

    private boolean status;

    public UserDTO(long id, String nome, String email, String telefone, int idade, String cep, int tipoDeficiencia){
        this.id = id;
        this.name = nome;
        this.email = email;
        this.phone = telefone;
        this.age = idade;
        this.cep = cep;
        this.typeOfDisability = tipoDeficiencia;
        this.status = true;
    }


    public UserDTO() {}
}

