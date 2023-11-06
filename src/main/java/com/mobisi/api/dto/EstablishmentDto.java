package com.mobisi.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EstablishmentDto {
    @Override
    public String toString() {
        return "EstablishmentDto{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", priceLevel='" + priceLevel + '\'' +
                ", openingHours=" + openingHours +
                ", popularity=" + popularity +
                ", photos=" + photos +
                '}';
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty(value = "rating", required = false)
    private double rating;

    @JsonProperty(value = "price_level", required = false)
    private String priceLevel;

    @JsonProperty(value = "opening_hours", required = false)
    private Object openingHours;

    @JsonProperty(value = "popularity", required = false)
    private int popularity;

    @JsonProperty(value = "photos", required = false)
    private Object photos;
}
