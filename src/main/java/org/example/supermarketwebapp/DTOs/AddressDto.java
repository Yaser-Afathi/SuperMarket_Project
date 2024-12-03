package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class AddressDto {
    private int idAddress;
    private String city;
    private String state;
    private String streetAddress;
    private String zipcode;
}

