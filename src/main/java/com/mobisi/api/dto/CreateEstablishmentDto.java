package com.mobisi.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEstablishmentDto {
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is NULL")
    private String name;

    @NotNull(message = "Invalid score: score is NULL")
    @PositiveOrZero(message = "Invalid score: score must be a positive or zero value")
    private double score;

    @NotNull(message = "Invalid cep: cep is NULL")
    @PositiveOrZero(message = "Invalid cep: age must be a positive or zero value")
    private int cep;

    @NotNull(message = "Invalid typeOfEstablishment: typeOfEstablishment is NULL")
    private int typeOfEstablishment;
}
