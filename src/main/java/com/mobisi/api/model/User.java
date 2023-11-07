package com.mobisi.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

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

    @Column(name = "dcriacao")
    private Date createAt;

    @Column(name = "datualizacao")
    private Date updateAt;

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

    @Column(name = "ccep")
    private String cep;

    @Column(name = "ccidade")
    private String city;

    @Column(name = "cbairro")
    private String neighborhood;

    @Column(name = "cestado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "itipodeficienciaid")
    private DisabilityType disability;

    @Transient
    private Integer disabilityType;

    @Column(name = "iativo")
    private int status = 1;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", cep='" + cep + '\'' +
                ", city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", state='" + state + '\'' +
                ", disability=" + disability +
                ", disabilityType='" + disabilityType + '\'' +
                ", status=" + status +
                '}';
    }
}