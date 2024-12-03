package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class ProductDto {
    private int idProduct;
    private String name;
    private Double price;
    private String description;
    private int availableUnits;
    private String imageUrl;
    private CategoryDto category;
    // Other fields as needed
    // Getters and setters
}
