package com.mobisi.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlterUserDto {
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String name;
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String phone;
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String email;
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String cep;
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String neighborhood;
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String state;
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String city;


}
