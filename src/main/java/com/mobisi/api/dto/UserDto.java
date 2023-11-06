package com.mobisi.api.dto;

import com.mobisi.api.model.DisabilityType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String phone;
    private int age;
    private String cep;
    private String disabilityType;
}