package com.mobisi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstablishmentDto {
    private Long id;
    private String name;
    private double score;
    private int cep;
    private int typeOfEstablishment;
}
