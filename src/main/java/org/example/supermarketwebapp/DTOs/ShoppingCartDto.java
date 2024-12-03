package org.example.supermarketwebapp.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@Data
public class ShoppingCartDto {
    private int idCart;
    private List<ProductDto> productList;
    // Other fields as needed
    // Getters and setters
}
