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
                ", internationalPhoneNumber='" + internationalPhoneNumber + '\'' +
                ", website='" + website + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", openingHours=" + openingHours +
                ", popularity=" + popularity +
                ", photos=" + photos +
                '}';
    }

    @JsonProperty(value = "name", required = false)
    private String name;

    @JsonProperty(value = "rating", required = false)
    private double rating;

    @JsonProperty(value = "international_phone_number", required = false)
    private String internationalPhoneNumber;

    @JsonProperty(value = "website", required = false)
    private String website;

    @JsonProperty(value = "priceRange", required = false)
    private String priceRange;

    @JsonProperty(value = "openingHours", required = false)
    private Object openingHours;

    @JsonProperty(value = "popularity", required = false)
    private int popularity;

    @JsonProperty(value = "photos", required = false)
    private Object photos;
}
