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
    private String password;
    private String phone;
    private String cep;
    private String city;
    private String neighborhood;
    private String state;
    private Integer disabilityType;
}