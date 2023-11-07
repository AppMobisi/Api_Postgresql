package com.mobisi.api.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String name;

    @NotBlank(message = "Invalid email: Empty email")
    @NotNull(message = "Invalid email: email is NULL")
    @Email(message = "Invalid email: email is not a valid email")
    private String email;

    @NotBlank(message = "Invalid password: Empty password")
    @NotNull(message = "Invalid password: password is NULL")
    private String password;

    @NotBlank(message = "Invalid CPF: Empty CPF")
    @NotNull(message = "Invalid CPF: CPF is NULL")
    private String cpf;

    @NotBlank(message = "Invalid phone: Empty phone")
    @NotNull(message = "Invalid phone: phone is NULL")
    private String phone;

    @NotBlank(message = "Invalid cep: Empty cep")
    @NotNull(message = "Invalid age: age is NULL")
    private String cep;

    @NotBlank(message = "Invalid city: Empty city")
    private String city;

    @NotBlank(message = "Invalid neighborhood: Empty neighborhood")
    private String neighborhood;

    @NotBlank(message = "Invalid state: Empty state")
    private String state;

    @NotNull(message = "Invalid disabilityType: disabilityType is NULL")
    private Long disabilityType;
}
